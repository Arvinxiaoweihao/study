package contronller;

import com.thunisoft.spring.contronller.UserContronller;
import com.thunisoft.spring.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Description: 用户控制层测试类
 * @Author: Administrator
 * @CreateDate: 2018/8/29 23:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")//相对于calsspath的路径
public class UserContronllerTest {

    @Resource
    private UserContronller userContronller;

    @Test
    public void Test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserContronller userContronller = (UserContronller) context.getBean("userContronller");
        User user = userContronller.getUser("1");
        System.out.println(user);
    }

    @Test
    public void getUserTest() {

    }
}
