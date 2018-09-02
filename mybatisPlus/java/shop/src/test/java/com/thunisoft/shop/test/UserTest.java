package com.thunisoft.shop.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thunisoft.shop.domain.User;
import com.thunisoft.shop.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


/**
 * 用户处理相关的测试.
 * @author ljw on 2017-8-28上午10:58:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml") //相对于calsspath的路径
//@ContextConfiguration("/applicationContext.xml") //绝对路径
public class UserTest {

    @Autowired
    private IUserService userService;

//    @Autowired
//    private IProductService productService;

    
    @Test
    public void testSave() throws Exception {
        User user = new User("ww", "123", "ww@163.com", new Date(), "127.0.0.1", "12345", "成都", "王五");
        userService.save(user);
    }
    
    @Test
    public void testUpdate() throws Exception {
        User user = new User("lw", "123", "lw@163.com", new Date(), "127.0.0.1", "12345", "成都", "老王");
        user.setId(22L);
        userService.update(user);
    }
    
    @Test
    public void testDelete() throws Exception {
        userService.delete(20L);
    }
    
    @Test
    public void testGet() throws Exception {
        User user = userService.getUserById(2L);
        System.out.println(user);
    }
    
    @Test
    public void testFind() throws Exception {
        PageHelper.startPage(1, 3);
        List<User> userList = userService.find();
        for (User user : userList) {
            System.out.println(user);
        }
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        long total = pageInfo.getTotal(); //获取总记录数
        System.out.println("总数是："+total);
    }
    
}
