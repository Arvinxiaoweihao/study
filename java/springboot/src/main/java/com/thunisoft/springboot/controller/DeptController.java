package com.thunisoft.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 部门控制器类
 * @Author: Administrator
 * @CreateDate: 2018/9/16 21:34
 */
@RestController
@RequestMapping("/dept")//添加类的访问路径
public class DeptController {

    //访问http://localhost:8080/springboot/dept/getDept?id=25 获取参数
    @GetMapping(value="/getDept")
    public String getDept(@RequestParam(value="id",required = false,defaultValue = "20") Integer deptId){
        return "id= "+deptId;
    }
}
