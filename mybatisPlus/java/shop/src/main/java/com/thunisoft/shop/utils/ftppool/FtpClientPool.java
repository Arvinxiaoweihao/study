package com.thunisoft.shop.utils.ftppool;

import com.thunisoft.shop.domain.ftp.FtpConfig;
import com.thunisoft.shop.utils.PropertiesUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**  
 * @Description: 对象池:掌管对象的生命周期，获取，激活，验证，钝化，销毁等
 * @author Administrator 
 * @date 2018年3月27日 下午11:40:43 
 * @version v1.0
 */
public class FtpClientPool {

    /** 使用GenericObjectPool封装一个连接池*/
    private static final GenericObjectPool<FTPClient> ftpClientPool;
    
    private static final FtpConfig ftpConfig;
    
    private FtpClientPool(){
        
    }
    
    static{
        PropertiesUtil propertiesUtil = new PropertiesUtil("ftp-storage.properties");
     // 初始化对象池配置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(Integer.parseInt(propertiesUtil.getProperty("ftp_pool_maxTotal")));
        poolConfig.setMaxIdle(Integer.parseInt(propertiesUtil.getProperty("ftp_pool_maxIdle")));
        poolConfig.setMinIdle(Integer.parseInt(propertiesUtil.getProperty("ftp_pool_minIdle")));
        poolConfig.setMaxWaitMillis(Long.parseLong(propertiesUtil.getProperty("ftp_pool_maxWaitMillis")));
        poolConfig.setBlockWhenExhausted(Boolean.parseBoolean(propertiesUtil.getProperty("ftp_pool_blockWhenExhausted")));
        poolConfig.setTestOnBorrow(Boolean.parseBoolean(propertiesUtil.getProperty("ftp_pool_testOnBorrow")));
        poolConfig.setTestOnReturn(Boolean.parseBoolean(propertiesUtil.getProperty("ftp_pool_testOnReturn")));
        poolConfig.setTestOnCreate(Boolean.parseBoolean(propertiesUtil.getProperty("ftp_pool_testOnCreate")));
        poolConfig.setTestWhileIdle(Boolean.parseBoolean(propertiesUtil.getProperty("ftp_pool_testWhileIdle")));
        poolConfig.setLifo(Boolean.parseBoolean(propertiesUtil.getProperty("ftp_pool_lifo")));
        poolConfig.setLifo(Boolean.parseBoolean(propertiesUtil.getProperty("ftp_pool_timeBetweenEvictionRunsMillis")));
        poolConfig.setLifo(Boolean.parseBoolean(propertiesUtil.getProperty("ftp_pool_minEvictableIdleTimeMillis")));
        poolConfig.setLifo(Boolean.parseBoolean(propertiesUtil.getProperty("ftp_pool_softMinEvictableIdleTimeMillis")));
        //初始化FTP连接属性配置
        ftpConfig=new FtpConfig();
        ftpConfig.setHost(propertiesUtil.getProperty("ftp_client_host"));
        ftpConfig.setPort(Integer.parseInt(propertiesUtil.getProperty("ftp_client_port")));
        ftpConfig.setUsername(propertiesUtil.getProperty("ftp_client_username"));
        ftpConfig.setPassword(propertiesUtil.getProperty("ftp_client_pasword"));
        ftpConfig.setPassiveMode(Boolean.parseBoolean(propertiesUtil.getProperty("ftp_client_passiveMode")));
        ftpConfig.setEncoding(propertiesUtil.getProperty("ftp_client_encoding"));
        ftpConfig.setClientTimeout(Integer.parseInt(propertiesUtil.getProperty("ftp_client_clientTimeout")));
        ftpConfig.setTransferFileType(Integer.parseInt(propertiesUtil.getProperty("ftp_client_transferFileType")));
        ftpConfig.setBufferSize(Integer.parseInt(propertiesUtil.getProperty("ftp_client_bufferSize")));
        ftpConfig.setBasepath(propertiesUtil.getProperty("ftp_client_basepath"));
        ftpConfig.setCreateSmallFile(Boolean.parseBoolean(propertiesUtil.getProperty("ftp_client_createSmallFile")));
        // 初始化对象池
        ftpClientPool = new GenericObjectPool<FTPClient>(new FtpClientFactory(ftpConfig), poolConfig);
    }
    
    /**
     * 客户端从池中借出一个对象
     * @return
     * @throws Exception
     */
    public static FTPClient borrowObject() throws Exception{
        return ftpClientPool.borrowObject();
    }
    
    /**
     * 客户端归还一个对象到池中
     * @param ftpClient
     * @throws Exception
     */
    public static void returnObject(FTPClient ftpClient) throws Exception{
        if(ftpClient != null){
            ftpClientPool.returnObject(ftpClient);
        }
    }
    
    /**
     * 获取FTP连接属性配置
     * @return
     */
    public static FtpConfig getFtpConfig(){
        return ftpConfig;
    }
}
