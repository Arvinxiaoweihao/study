package com.thunisoft.shop.utils.ftppool;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thunisoft.shop.domain.ftp.FtpConfig;
import com.thunisoft.shop.utils.StringUtil;

/**
 * @Description: 池对象工厂:池中对象各个生命周期的具体实现，怎么创建，怎么验证，怎么销毁
 * @author Administrator 
 * @date 2018年3月27日 下午10:36:44 
 * @version v1.0
 */
public class FtpClientFactory extends BasePooledObjectFactory<FTPClient>{
    /**日志*/
    private final static Logger logger = LoggerFactory.getLogger(FtpClientFactory.class);
    
    /**FTP连接属性配置*/
    private FtpConfig ftpConfig;
    
    /**
     * 有参构造器
     * @param ftpConfig ftp配置属性
     */
    public FtpClientFactory(FtpConfig ftpConfig) {
        this.ftpConfig = ftpConfig;
    }
    

    /** 
     * 创建一个池对象（被创建在池中的对象）
     * @exception Exception
     */
    @Override
    public FTPClient create() throws Exception {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(ftpConfig.getClientTimeout());
        
        // 连接FTP服务器， 获取ftp服务器返回码，验证是否登陆成功
        String ip = ftpConfig.getHost();
        int port = ftpConfig.getPort();
        
        ftpClient.connect(ftpConfig.getHost(), ftpConfig.getPort());
        int replyCode = ftpClient.getReplyCode();
        if(!FTPReply.isPositiveCompletion(replyCode)){
            ftpClient.disconnect();
            StringBuilder sb = new StringBuilder("FTPServer 拒绝连接!");
            sb.append("，ip：").append(ip).append("，端口：").append(port);
            throw new RuntimeException(sb.toString());
        }
        
     // 登录FTP服务器，验证是否登录成功
        String username = ftpConfig.getUsername();
        String password = ftpConfig.getPassword();
        boolean success = ftpClient.login(ftpConfig.getUsername(), ftpConfig.getPassword());
        if(!success){
            StringBuilder sb = new StringBuilder("ftpClient登陆失败!");
            sb.append("，ip：").append(ip).append("，端口：").append(port);
            sb.append("，用户名：").append(username).append("，密码：").append(password);
            throw new RuntimeException(sb.toString());
        }
        //设置传输的编码格式，设置文件传输类型为二进制，缓存大小
        ftpClient.setControlEncoding(ftpConfig.getEncoding());
        ftpClient.setFileType(ftpConfig.getTransferFileType());
        ftpClient.setBufferSize(ftpConfig.getBufferSize());
        //连接是否为主动模式
        if(ftpConfig.isPassiveMode()){
            ftpClient.enterLocalPassiveMode();
        }
        return ftpClient;
    }

    
    /** 
     * 用PooledObject封装对象放入池中，返回池对象（被创建在池中的对象）
     * @param ftpClient ftpClient对象
     */
    @Override
    public PooledObject<FTPClient> wrap(FTPClient ftpClient) {
        return new DefaultPooledObject<FTPClient>(ftpClient);
    }
    
    /**
     * 销毁一个池对象（被创建在池中的对象）
     * @param pooledObject 池对象
     */
    @Override
    public void destroyObject(PooledObject<FTPClient> pooledObject) throws Exception {
        FTPClient ftpClient = pooledObject.getObject();
        try {
            if (ftpClient != null && ftpClient.isConnected()) {
                 ftpClient.logout();
            }
       } catch (IOException io) {
           logger.info("ftpClient登出异常，直接断开连接");
       } finally {
            // 注意,一定要在finally代码中断开连接，否则会导致占用ftp连接情况
           try {
               ftpClient.disconnect();
          } catch (IOException io) {
              logger.info("ftpClient断开连接异常，无法销毁");
          }
       }
    }

    /**
     * 验证一个池对象（被创建在池中的对象）是否还可用
     * @param pooledObject 池对象
     */
    @Override
    public boolean validateObject(PooledObject<FTPClient> pooledObject) {
        FTPClient ftpClient = pooledObject.getObject();
        try {
            return ftpClient.sendNoOp();
        } catch (IOException e) {
           logger.info("ftpClient对象断开了连接,等待销毁");
        }
        return false;
    }
}
