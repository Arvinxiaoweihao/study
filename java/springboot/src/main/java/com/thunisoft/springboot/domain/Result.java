package com.thunisoft.springboot.domain;

/**
 * @Description: 结果对象
 * @Author: Administrator
 * @CreateDate: 2018/9/22 17:46
 */
public class Result {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String message;

    /** 结果数据. */
    private Object data;


    /**
     * 获取 错误码.
     *
     * @return code 错误码.
     */
    public Integer getCode() {
        return this.code;
    }

    /**
     * 设置 错误码.
     *
     * @param code 错误码.
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取 提示信息.
     *
     * @return message 提示信息.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 设置 提示信息.
     *
     * @param message 提示信息.
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * 获取 结果数据.
     *
     * @return data 结果数据.
     */
    public Object getData() {
        return this.data;
    }

    /**
     * 设置 结果数据.
     *
     * @param data 结果数据.
     */
    public void setData(Object data) {
        this.data = data;
    }
}
