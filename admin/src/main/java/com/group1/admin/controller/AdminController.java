package com.group1.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group1.admin.service.AdminService;
import com.group1.core.admin.model.Admin;
import com.group1.core.utils.ResultBody;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
            resultBody.setStatus("1");
            resultBody.setMessage("ok");
            resultBody.setData("admin",adminService.register(admin));
        }else {
            resultBody.setStatus("2");
            resultBody.setMessage("errors");
            resultBody.setData("errorList",errors.getAllErrors());
        }
        return resultBody;
    }
}
