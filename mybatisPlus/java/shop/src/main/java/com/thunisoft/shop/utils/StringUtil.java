package com.thunisoft.shop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**  
 * @Description: 字符串工具
 * @author Administrator 
 * @date 2018年3月27日 下午11:03:41 
 * @version v1.0
 */
public class StringUtil {
    /**
    * 获取年月日字符串如：20170901
    * @return
    */
    public static String getYyrStr() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    /**
     * 获取去“-”后的32位uuid
     * @return
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    /**
     * sql语句拼接条件
     * @param isWhere 是不是拼接where
     * @param whereSql 条件sql
     * @return
     */
    public static boolean isWhere(boolean isWhere,StringBuilder whereSql){
        if(isWhere){
            whereSql.append("where ");
            isWhere = false;
        }else{
            whereSql.append("and ");
        }
        return isWhere;
    }
}
