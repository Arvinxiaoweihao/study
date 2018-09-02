package com.thunisoft.shop.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 描述： spring工具类，用户获取bean.
 * 作者： Administrator
 * 时间： 2017年7月24日下午9:01:30
 * 版本： 1.0
 *
 */
public class SpringUtil implements ApplicationContextAware {

    /**注入applicationContext.*/
    private static ApplicationContext applicationContext;

    /**
     * 注入applicationContext.
     * @param applicationContext beanFactory的直接口，用于获取bean
     * @exception BeansException bean异常
     */
    public void setApplicationContext(
            ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext上下文.
     * @return applicationContext 上下文
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据bean的id获取相应的bean.
     * @param idName bean的id
     * @return bean
     */
    public static Object getBean(String idName) {
        return applicationContext.getBean(idName);
    }



}
