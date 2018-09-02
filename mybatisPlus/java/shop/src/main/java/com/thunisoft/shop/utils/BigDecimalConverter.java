package com.thunisoft.shop.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;

import java.math.BigDecimal;
import java.util.Map;

public class BigDecimalConverter extends StrutsTypeConverter{

    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        BigDecimal bd = null;
        if(BigDecimal.class == aClass){
            String bdStr = strings[0];
            if(StringUtils.isNotBlank(bdStr)){
                bd = new BigDecimal(bdStr);
            }
            return bd;
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String convertToString(Map map, Object o) {
        if (o instanceof BigDecimal){
            BigDecimal b = new BigDecimal(o.toString()).setScale(2,BigDecimal.ROUND_HALF_DOWN);
            return b.toString();
        }
        return o.toString();
    }
}
