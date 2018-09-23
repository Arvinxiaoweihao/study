package com.thunisoft.springboot.util;

import com.thunisoft.springboot.constant.enums.DeptResultEnum;
import com.thunisoft.springboot.domain.Result;

/**
 * @Description: 结果工具类
 * @Author: Administrator
 * @CreateDate: 2018/9/22 17:49
 */
public class ResultUtil {

    /**
     * 返回成功
     * @param object 返回内容
     * @return
     */
    public static Result successResult(Object object){
        Result result = new Result();
        result.setCode(DeptResultEnum.SUCCESS.getCode());
        result.setMessage(DeptResultEnum.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }

    /**
     * 返回成功
     * @return
     */
    public static Result successResult(){
        return successResult(null);
    }

    /**
     * 返回失败
     * @param code code值
     * @param message 提示信息
     * @return
     */
    public static Result failedResult(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}
