package com.thunisoft.springboot.exception;

import com.thunisoft.springboot.constant.enums.DeptResultEnum;

/**
 * @Description: 自定义异常
 * @Author: Administrator
 * @CreateDate: 2018/9/22 18:32
 */
public class DeptException extends RuntimeException {

    /** code值. */
    private Integer code;

    public DeptException(DeptResultEnum deptResultEnum) {
        super(deptResultEnum.getMessage());
        this.code = deptResultEnum.getCode();
    }


    /**
     * 获取 
     *
     * @return code
     */
    public Integer getCode() {
        return this.code;
    }

    /**
     * 设置 
     *
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }
}
