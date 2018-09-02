package com.thunisoft.shop.utils.ftppool;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

/**  
 * @Description: 文件工具类
 * @author Administrator 
 * @date 2018年3月27日 下午11:09:46 
 * @version v1.0
 */
public class FileUtil {
    
    /**私有构造器*/
    private FileUtil(){
        
    }

    /**
     * 得到小写扩展名（都转为小写）
     * @param file
     * @return
     */
    public static String getLowerCaseExtName(File file) {
        String extr = FilenameUtils.getExtension(file.getName());
        if(StringUtils.isNotBlank(extr)){
            extr = extr.toLowerCase();
        }
        return extr; 
    }
}
