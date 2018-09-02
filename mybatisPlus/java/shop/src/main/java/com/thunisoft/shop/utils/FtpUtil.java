/*
 * @(#)FtpUtil.java 2017-9-11下午1:57:31
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thunisoft.shop.domain.ftp.FtpBean;


/**
 * @author ljw on 2017-9-11下午1:57:31
 */
public class FtpUtil {

    /** 日志组件. */
    private final static Logger logger = LoggerFactory.getLogger(FtpUtil.class);
    
    private static FTPClient ftpClient = new FTPClient();

    /**
     * 向FTP服务器上传文件
     * @param FtpBean 封装的ftp参数对象
     * @param path FTP服务器保存目录,如果是根目录则为“/”
     * @param fileName 上传到FTP服务器上的文件名
     * @param input 本地文件输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(FtpBean ftpBean,String path, String fileName, InputStream input) {
        boolean result = false;
        try {
         // 连接FTP服务器， 获取ftp服务器返回码，验证是否登陆成功
            ftpClient.connect(ftpBean.getUrl(), ftpBean.getPort());
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                throw new RuntimeException("FTPServer 拒绝连接");
            }
            
         // 登录FTP服务器，验证是否登录成功
            boolean success = ftpClient.login(ftpBean.getUserName(), ftpBean.getPassword());
            if (!success) {
                ftpClient.disconnect();
                throw new RuntimeException("ftpClient登陆失败!");
            }
            
            //设置传输的编码格式，设置文件传输类型为二进制，设置为主动模式（pass）
            ftpClient.setControlEncoding(ftpBean.getEncoding());
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            
          String replDirPath = path.replace("\\","/");
          //切换工作目录到根目录
          ftpClient.changeWorkingDirectory("/");
          boolean change = ftpClient.changeWorkingDirectory(path);
          if(!change){
              String[] ftppaths = replDirPath.split("/");  
              //将文件目录按路径分隔符读取，然后分别创建  
              for(int i=0; i<ftppaths.length; i++) {  
                  String folder = ftppaths[i];
                  if(StringUtils.isNotBlank(folder)){
                      ftpClient.makeDirectory(folder);  
                      change = ftpClient.changeWorkingDirectory(folder);
                  }
              }  
          }
        if (change) {
            result = ftpClient.storeFile(new String(fileName.getBytes(ftpBean.getEncoding()), "iso-8859-1"), input);
        }
            ftpClient.logout();
        } catch (IOException e) {
            logger.error("上传失败", e);
        } finally {
            IOUtils.closeQuietly(input);
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                    logger.error("关闭ftp客户端失败", ioe);
                }
            }
        }
        return result;
    }
    
    /**
     * 从FTP服务器下载文件
     * @param ftpBean 封装的ftp参数对象
     * @param path FTP服务器保存目录,如果是根目录则为“/”
     * @param fileName 上传到FTP服务器上的文件名
     * @return
     */
    public static InputStream downloadFile(FtpBean ftpBean, String path, String fileName) {
        InputStream in = null;
        try {
         // 连接FTP服务器， 获取ftp服务器返回码，验证是否登陆成功
            ftpClient.connect(ftpBean.getUrl(), ftpBean.getPort());
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                throw new RuntimeException("FTPServer 拒绝连接");
            }
            
         // 登录FTP服务器，验证是否登录成功
            boolean success = ftpClient.login(ftpBean.getUserName(), ftpBean.getPassword());
            if (!success) {
                ftpClient.disconnect();
                throw new RuntimeException("ftpClient登陆失败!");
            }
            
            //设置传输的编码格式，设置文件传输类型为二进制，设置为主动模式（pass）
            ftpClient.setControlEncoding(ftpBean.getEncoding());
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            
            // 转移到FTP服务器目录至指定的目录下,获取文件列表
            ftpClient.changeWorkingDirectory(new String(path.getBytes(ftpBean.getEncoding()), "iso-8859-1"));
            FTPFile[] fs = ftpClient.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    in = ftpClient.retrieveFileStream(fileName);
                }
            }
            ftpClient.logout();
        } catch (IOException e) {
            logger.error("下载失败",e);
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                    logger.error("关闭ftp客户端失败",ioe);
                }
            }
        }
        return in;
    }
    
    /**
     * 从FTP服务器下载文件
     * @param ftpBean 封装的ftp参数对象
     * @param path FTP服务器保存目录,如果是根目录则为“/”
     * @param fileName 上传到FTP服务器上的文件名
     * @return
     */
    public static boolean downloadFile(FtpBean ftpBean, String path, String fileName,OutputStream outputPath) {
        boolean result = false;
        try {
         // 连接FTP服务器， 获取ftp服务器返回码，验证是否登陆成功
            ftpClient.connect(ftpBean.getUrl(), ftpBean.getPort());
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                throw new RuntimeException("FTPServer 拒绝连接");
            }
            
         // 登录FTP服务器，验证是否登录成功
            boolean success = ftpClient.login(ftpBean.getUserName(), ftpBean.getPassword());
            if (!success) {
                ftpClient.disconnect();
                throw new RuntimeException("ftpClient登陆失败!");
            }
            
            //设置传输的编码格式，设置文件传输类型为二进制，设置为主动模式（pass）
            ftpClient.setControlEncoding(ftpBean.getEncoding());
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            
            // 转移到FTP服务器目录至指定的目录下，获取文件列表
            ftpClient.changeWorkingDirectory(new String(path.getBytes(ftpBean.getEncoding()), "iso-8859-1"));
            FTPFile[] fs = ftpClient.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    result = ftpClient.retrieveFile(fileName, outputPath);
                }
            }
            ftpClient.logout();
        } catch (IOException e) {
            logger.error("下载失败",e);
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                    logger.error("关闭ftp客户端失败",ioe);
                }
            }
        }
        return result;
    }
    
    /**
     * 从FTP服务器下载文件
     * @param ftpBean 封装的ftp参数对象
     * @param path FTP服务器保存目录,如果是根目录则为“/”
     * @param fileName 上传到FTP服务器上的文件名
     * @return
     */
    public static boolean deleteFile(FtpBean ftpBean, String filePathAndName) {
        boolean result = false;
        try {
            // 连接FTP服务器， 获取ftp服务器返回码，验证是否登陆成功
            ftpClient.connect(ftpBean.getUrl(), ftpBean.getPort());
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                throw new RuntimeException("FTPServer 拒绝连接");
            }
            
            // 登录FTP服务器，验证是否登录成功
            boolean success = ftpClient.login(ftpBean.getUserName(), ftpBean.getPassword());
            if (!success) {
                ftpClient.disconnect();
                throw new RuntimeException("ftpClient登陆失败!");
            }
            
            //设置传输的编码格式，设置文件传输类型为二进制，设置为主动模式（pass）
            ftpClient.setControlEncoding(ftpBean.getEncoding());
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
           
            result = ftpClient.deleteFile(filePathAndName);
            ftpClient.logout();
        } catch (IOException e) {
            logger.error("下载失败",e);
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                    logger.error("关闭ftp客户端失败",ioe);
                }
            }
        }
        return result;
    }
    
}
