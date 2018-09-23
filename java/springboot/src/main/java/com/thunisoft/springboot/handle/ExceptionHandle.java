package com.thunisoft.springboot.handle;

import com.thunisoft.springboot.constant.enums.DeptResultEnum;
import com.thunisoft.springboot.domain.Result;
import com.thunisoft.springboot.exception.DeptException;
import com.thunisoft.springboot.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2018/9/22 18:45
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {
    /** 日志. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value=Exception.class)
    public Result deptExceptionHandle(Exception e){
        if(e instanceof DeptException){
            DeptException deptException = (DeptException) e;
           return  ResultUtil.failedResult(deptException.getCode(),deptException.getMessage());
        }
        //查询不到结果时
        if(e instanceof EntityNotFoundException){
            return ResultUtil.successResult();
        }
        LOGGER.error("系统异常",e);
        return ResultUtil.failedResult(DeptResultEnum.FAILED_UNKNOWN.getCode(),DeptResultEnum.FAILED_UNKNOWN.getMessage());
    }
}
