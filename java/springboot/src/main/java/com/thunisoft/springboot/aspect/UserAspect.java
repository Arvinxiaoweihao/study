package com.thunisoft.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 用户操作面向切面编程
 * @Author: Administrator
 * @CreateDate: 2018/9/20 23:07
 */
@Aspect
@Component("userAspect")
public class UserAspect {

    /** 日志. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAspect.class);

    @Pointcut("execution(public * com.thunisoft.springboot.controller.UserController.*(..))")
    public void deal(){
        //@Pointcut在UserController类的切入方法上声明，@Before等也指向切入方法
        //该方法得不到执行
    }

    @Before("deal()")
    public void dealBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        LOGGER.info("url={}",request.getRequestURL());
        //请求方式
        LOGGER.info("method={}",request.getMethod());
        //ip
        LOGGER.info("ip={}",request.getRemoteAddr());
        //类方法
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    @After("deal()")
    public void dealAfter(){
        LOGGER.info("dealAfter");
    }

    @AfterReturning(returning = "object",pointcut = "deal()")
    public void afterReturning(Object object){
        LOGGER.info("result={}",object);
    }
}
