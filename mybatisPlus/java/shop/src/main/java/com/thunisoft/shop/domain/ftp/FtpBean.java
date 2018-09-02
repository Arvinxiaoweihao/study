/*
 * @(#)FtpBean.java 2017-9-11上午11:11:11
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.domain.ftp;

import com.thunisoft.shop.utils.Global;
import com.thunisoft.shop.utils.PropertiesUtil;

/**
 * ftp参数实体类.
 * @author ljw on 2017-9-11上午11:11:11
 */
public class FtpBean {

    private String url;
    private String userName;
    private String password;
    private int port;
    private String basePath;
    private String encoding;
    private static PropertiesUtil properties;
    
    static{
        properties =new PropertiesUtil(Global.FTP_PROPERTIES);
    }
    
    public FtpBean() {
        this.url = properties.getProperty("ftp_client_host");
        this.userName = properties.getProperty("ftp_client_username");
        this.password = properties.getProperty("ftp_client_pasword");
        this.port = Integer.valueOf(properties.getProperty("ftp_client_port"));
        this.basePath = properties.getProperty("ftp_client_workingDirectory");
        this.encoding = properties.getProperty("ftp_client_encoding");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    
}
