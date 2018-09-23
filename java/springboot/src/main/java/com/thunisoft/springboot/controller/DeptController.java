package com.thunisoft.springboot.controller;

import com.thunisoft.springboot.constant.enums.DeptResultEnum;
import com.thunisoft.springboot.domain.Dept;
import com.thunisoft.springboot.service.IDeptService;
import com.thunisoft.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description: 部门控制器类
 * @Author: Administrator
 * @CreateDate: 2018/9/16 21:34
 */
@RestController
@RequestMapping("/dept")//添加类的访问路径
public class DeptController {

    @Autowired
    private IDeptService deptService;

    /**
     * 查询部门
     * @return
     */
    @GetMapping(value="/listDept")
    public List<Dept> listDept(){
        return deptService.listDept();
    }

    /**
     * 查询部门
     * @param id id
     * @return
     */
    @GetMapping(value="getDept")
    public Object getDept(@RequestParam("id") Integer id) throws Exception {
        Object dept = deptService.getDept(id);
        return ResultUtil.successResult(dept);
    }

    /**
     * 新建部门
     * @param dept
     * @param bindingResult
     * @return
     */
    @PostMapping(value="/saveDept")
    public Object saveDept(@Valid Dept dept, BindingResult bindingResult){
        //bindingResult为验证结果
        if(bindingResult.hasErrors()){
            return ResultUtil.failedResult(DeptResultEnum.FAILED.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.successResult(deptService.saveDept(dept));
    }
}
