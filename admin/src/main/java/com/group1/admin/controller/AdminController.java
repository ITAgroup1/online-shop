package com.group1.admin.controller;

import com.group1.admin.service.AdminService;
import com.group1.core.entity.admin.Admin;
import com.group1.core.utils.ResultBody;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@CrossOrigin(origins = "*", maxAge = 100000)
public class AdminController {

    @Resource(name="adminService")
    private AdminService adminService;

    @PostMapping("/admin/login")
    @ResponseBody
    public ResultBody login(@Valid Admin admin, Errors errors, HttpServletRequest request){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            Admin a = adminService.login(admin);
            if(a!=null) {
                System.out.println(a);
                request.getSession().setAttribute("admin",a);
                resultBody.addData("url", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/html/listVerify.html");
            }else{
                resultBody.setMessage("logiName or password is invalid");
                resultBody.addError("errors","logiName or password is invalid");
            }
        }else {
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

//    @RequestMapping("/listVerify")
//    public String listVerify(){
//        return "listVerify";
//    }
//
//    @RequestMapping("/listUpdate")
//    public String listUpdate(){
//        return "listUpdate";
//    }
//
//    @RequestMapping("/listComplaint")
//    public String listComplaints(){
//        return "listComplaint";
//    }
}
