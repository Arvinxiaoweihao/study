package com.thunisoft.shop.service;

import java.io.File;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;


/**
 * ftp存储文档
 * @author ljw
 * @Date 2016-7-14 下午6:22:54
 * @version 1.0.0
 */
public interface IFtpService {
    
    /**
     * 上传文件,上传后自动生成随机文件名
     * @param file  文件
     * @param ftpClient ftp客户端
     * @return  文件存储地址+文件名
     * @throws Exception
     */
    String upLoadFile(File file,FTPClient ftpClient) throws Exception;
    
    /**
     * 上传文件,上传后自动生成随机文件名,针对file为临时文件情况
     * @param file  临时文件（xx.tmp）
     * @param ftpClient ftp客户端
     * @param realFileName 真实文件名
     * @return  文件存储地址+文件名
     * @throws Exception
     */
    String upLoadTmpFile(File file, String realFileName,FTPClient ftpClient) throws Exception;
    
    /**
     * 生成缩略图并上载
     * @param file 文件
     * @param bigFilePathAndName 大图的路径和名字
     * @param ftpClient ftp客户端
     * @return
     */
    String uploadSmallFile(File file, String bigFilePathAndName,FTPClient ftpClient) throws Exception;
    
    /**
     * 上传文件,指定上传后的文件名
     * @param file  文件
     * @param fileName 文件名
     * @param ftpClient ftp客户端
     * @return  文件存储地址+文件名
     * @throws Exception
     */
    public String upLoadFile(File file,String fileName,FTPClient ftpClient) throws Exception;
    
    /**
     * 上传文件,指定上传后的文件名（目标文件名）
     * @param inputStream  文件输入流
     * @param targetFileName 目标文件名
     * @param ftpClient ftp客户端
     * @return  文件存储地址+文件名
     * @throws Exception
     */
    String upLoadFile(InputStream inputStream, String targetFileName,FTPClient ftpClient) throws Exception;


    /**
     * 下载文件,返回流，用户浏览器</br>
     * 调用者必须先关闭inputStream，再调用ftpClient.completePendingCommand();</br>
     * completePendingCommand()会一直在等FTP Server返回226 Transfer complete，</br>
     * 但是FTP Server只有在接受到InputStream执行close方法时，才会返回。所以先要执行close方法</br>
     * 如果没写ftpClient.completePendingCommand();会导致后面对FTPClient的操作都失败
     * @param filePathAndName  文件存储地址+文件名字
     * @param ftpClient ftp客户端
     * @return  文件流
     * @throws Exception 
     */
    InputStream downloadFile(String filePathAndName,FTPClient ftpClient) throws Exception;
    
    /**
     * 下载文件,返回流，用户浏览器
     * @param filePathAndName  文件存储地址+文件名字
     * @param outputPath 输出文件的流
     * @param ftpClient ftp客户端
     * @return  文件流
     * @throws Exception 
     */
    File downloadFile(String filePathAndName,String outFilePathAndName,FTPClient ftpClient) throws Exception;
    
    /**
     * 删除文件
     * @param filePathAndName  文件存储地址+文件名字
     * @param ftpClient ftp客户端
     * @return  是否删除成功
     */
    boolean deleteFile(String filePathAndName,FTPClient ftpClient);
    
    /**
     * 删除附件
     * @param fileName 文件名
     * @param dirPath 工作空间下的路径
     * @param ftpClient ftp客户端
     * @return 是否删除成功
     */
    boolean deleteFile(String fileName,String dirPath,FTPClient ftpClient);



}
