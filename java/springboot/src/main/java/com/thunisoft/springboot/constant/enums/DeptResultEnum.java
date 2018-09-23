package com.thunisoft.springboot.constant.enums;

import org.omg.CORBA.UNKNOWN;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Description: 部门结果枚举
 * @Author: Administrator
 * @CreateDate: 2018/9/22 22:57
 */
public enum  DeptResultEnum {

    SUCCESS(0,"成功"),FAILED(1,"失败"),
    FAILED_LESS_FIVE(2,"人数不能少于5人"),FAILED_LESS_FIFTY(3,"人数不够，尽快扩充"),
    FAILED_UNKNOWN(4,"未知错误");

    /** code值. */
    private Integer code;
    /** 提示信息. */
    private String message;

     DeptResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取 $field.getDocComment()
     *
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 获取 $field.getDocComment()
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }
}
