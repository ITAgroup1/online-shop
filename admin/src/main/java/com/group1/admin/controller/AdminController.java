package com.group1.admin.controller;

import com.group1.admin.service.AdminService;
import com.group1.core.entity.admin.Admin;
import com.group1.core.utils.ResultBody;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

    @PostMapping("/register")
    @ResponseBody
    public ResultBody register(@Valid Admin admin,Errors errors){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            resultBody.setData("admin",adminService.register(admin));
        }else {
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultBody login(@Valid Admin admin,Errors errors){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            resultBody.setData("admin",adminService.login(admin));
        }else {
            resultBody.setData("errorList",errors.getAllErrors());
        }
        return resultBody;
    }
}
