package entity;

import com.thunisoft.spring.entity.User;
import org.apache.commons.collections4.MapUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: MapUtils测试测试类
 * @Author: Administrator
 * @CreateDate: 2018/9/9 10:56
 */
public class MapUtilsTests {


    @Test
    public void Test() {
        Map<String, Object> nullMap = null;
        Map<String, Object> map = new HashMap<>();
        map.put("user", new User());

        map.put("boolean", true);
        Assert.assertTrue(MapUtils.getBoolean(map, "boolean"));
        //转换失败,返回默认值false
        Assert.assertFalse(MapUtils.getBoolean(map, "user",false));
        //目标map为null,返回null
        Assert.assertNull(MapUtils.getBoolean(nullMap, "boolean"));
        //目标map为null,返回默认值false
        Assert.assertFalse(MapUtils.getBoolean(nullMap, "boolean", false));

        Assert.assertTrue(MapUtils.getBooleanValue(map, "boolean"));
        //转换失败,返回默认值false
        Assert.assertFalse(MapUtils.getBooleanValue(map, "user",false));
        //目标map为null,返回false
        Assert.assertFalse(MapUtils.getBooleanValue(nullMap, "boolean"));
        //目标map为null,返回默认值false
        Assert.assertFalse(MapUtils.getBooleanValue(nullMap, "boolean", false));

        map.put("integer", 5);
        Assert.assertEquals(Integer.valueOf(5), MapUtils.getInteger(map, "integer"));
        //转换失败,返回默认值5
        Assert.assertEquals(Integer.valueOf(5), MapUtils.getInteger(map, "integer",5));
        //目标map为null,返回null
        Assert.assertEquals(null, MapUtils.getInteger(nullMap, "integer"));
        //目标map为null,返回默认值5
        Assert.assertEquals(Integer.valueOf(5), MapUtils.getInteger(nullMap, "integer", 5));

        Assert.assertEquals(5, MapUtils.getIntValue(map, "integer"));
        //转换失败,返回默认值5
        Assert.assertEquals(5, MapUtils.getIntValue(map, "user",5));
        Assert.assertSame(5, MapUtils.getIntValue(map, "integer"));
        //目标map为null,返回0
        Assert.assertEquals(0, MapUtils.getIntValue(nullMap, "integer"));
        //目标map为null,返回默认值5
        Assert.assertEquals(5, MapUtils.getIntValue(nullMap, "integer", 5));

    }
}
