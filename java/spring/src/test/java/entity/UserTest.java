package entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2018/9/9 22:08
 */
@RunWith(PowerMockRunner.class)
public class UserTest {
    @Test
    @PrepareForTest(Source.class)
    public void testCallSystemStaticMethod()
    {
        PowerMockito.verifyStatic();
        Static.thirdStaticMethod(Mockito.anyInt()); // 以任何整数值被调用
    }
    static class Source {
        public String callSystemStaticMethod(String str)
        {
            return System.getProperty(str);
        }
    }
}
