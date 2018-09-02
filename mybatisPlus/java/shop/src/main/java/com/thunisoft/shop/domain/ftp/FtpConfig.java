package com.thunisoft.shop.domain.ftp;

import com.thunisoft.shop.utils.PropertiesUtil;

/**
 * 描述：FTP连接属性配置
 * 作者： Administrator
 * 时间： 2018年3月27日下午10:12:41
 * 版本： 1.0
 */
public class FtpConfig {
    /**ip*/
    private String host;
    /**端口*/
    private int port;
    /**登录名*/
    private String username;
    /**密码*/
    private String password;
    /**连接是否为主动模式*/
    private boolean passiveMode;
    /**编码*/
    private String encoding;
    /**超时时间*/
    private int clientTimeout;
    /**文件传送类型:0=ASCII_FILE_TYPE（ASCII格式） 1=EBCDIC_FILE_TYPE 2=LOCAL_FILE_TYPE（二进制文件）*/
    private int transferFileType;
    /**缓存大小*/
    private int bufferSize;
    /**默认进入的路径*/
    private String basepath;
    /**是否创建缩略图并上载（缩略图名为：大图名_mini.后缀）*/
    private boolean createSmallFile;
    
    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the passiveMode
     */
    public boolean isPassiveMode() {
        return passiveMode;
    }

    /**
     * @param passiveMode the passiveMode to set
     */
    public void setPassiveMode(boolean passiveMode) {
        this.passiveMode = passiveMode;
    }

    /**
     * @return the encoding
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * @param encoding the encoding to set
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * @return the clientTimeout
     */
    public int getClientTimeout() {
        return clientTimeout;
    }

    /**
     * @param clientTimeout the clientTimeout to set
     */
    public void setClientTimeout(int clientTimeout) {
        this.clientTimeout = clientTimeout;
    }

    /**
     * @return the transferFileType
     */
    public int getTransferFileType() {
        return transferFileType;
    }

    /**
     * @param transferFileType the transferFileType to set
     */
    public void setTransferFileType(int transferFileType) {
        this.transferFileType = transferFileType;
    }

    /**
     * @return the bufferSize
     */
    public int getBufferSize() {
        return bufferSize;
    }

    /**
     * @param bufferSize the bufferSize to set
     */
    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }


    /**
     * @return the basepath
     */
    public String getBasepath() {
        return basepath;
    }

    /**
     * @param basepath the basepath to set
     */
    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }

    /**
     * @return the createSmallFile
     */
    public boolean isCreateSmallFile() {
        return createSmallFile;
    }

    /**
     * @param createSmallFile the createSmallFile to set
     */
    public void setCreateSmallFile(boolean createSmallFile) {
        this.createSmallFile = createSmallFile;
    }

    /** (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FtpConfig [host=" + host + ", port=" + port + ", username="
                + username + ", password=" + password + ", passiveMode="
                + passiveMode + ", encoding=" + encoding + ", clientTimeout="
                + clientTimeout + ", transferFileType=" + transferFileType
                + ", bufferSize=" + bufferSize + ", basepath=" + basepath
                + ", isCreateSmallFile=" + createSmallFile + "]";
    }

    
    
    
}
