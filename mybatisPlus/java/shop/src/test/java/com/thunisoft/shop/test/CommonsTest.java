package com.thunisoft.shop.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description
 * @Author ljw
 * @Date 2018/7/4 16:03
 * @Version 1.0
 **/
public class CommonsTest {



    @Before
    public void beforeTest() throws Exception{
        System.out.println("测试方法之前做准备操作");
    }

    @After
    public void afterTest() throws Exception{
        System.out.println("测试方法之后做回收操作");
    }

    @Test
    public void myTest() throws Exception{
        System.out.println("测试方法");
        int a = 1;
        int b = 3;
        Assert.assertEquals(4,a+b);
    }
    @Test
    public void myTest1() throws Exception{
        System.out.println("测试方法1");
        int a = 1;
        int b = 3;
        Assert.assertEquals(5,a+b);
    }
}
