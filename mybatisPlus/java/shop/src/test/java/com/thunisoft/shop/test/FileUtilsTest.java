package com.thunisoft.shop.test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

public class FileUtilsTest {


    @Test
    public void testFind() throws Exception {
        File dir = new File("F://a");
        FileUtils.cleanDirectory(dir);
    }
}
