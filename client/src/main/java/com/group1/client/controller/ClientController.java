package com.group1.client.controller;

import com.group1.client.service.ClientService;
import com.group1.core.entity.client.Client;
import com.group1.core.entity.complaint.Complaint;
import com.group1.core.utils.ResultBody;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.group1.core.interceptor.SpringWebSocketHandlerInterceptor.ATTRIBUTES_USER;
import static com.group1.core.interceptor.SpringWebSocketHandlerInterceptor.ATTRIBUTES_USERID;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Resource(name="clientService")
    private ClientService clientService;

    @PostMapping("/register")
    @ResponseBody
    public ResultBody register(@RequestBody @Valid Client client,Errors errors){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            Client result = clientService.findClientByLoginName(client.getLoginName());
            if(result!=null){
                resultBody.addError("errors","該賬戶已經被注冊");
                return resultBody;
            }
            resultBody.addData("client",clientService.save(client));
        }else {
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;
    }

    @PutMapping
    @ResponseBody
    public ResultBody put(@RequestBody Client client,HttpSession session){
        String id = (String) session.getAttribute(ATTRIBUTES_USERID);
        ResultBody resultBody = new ResultBody();
        if(id==null&&"".equals(id)){
            resultBody.addError("errors","session过期，请重新登陆");
            return resultBody;
        }
        Client c = clientService.update(client,id);
        resultBody.addData("client",c);
        return resultBody;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultBody login(@RequestBody @Valid Client client, Errors errors, HttpSession session){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            Client result = clientService.login(client);
            System.out.println(result);
            if(result!=null){
                String userId = result.getId();
                System.out.println(userId+" 登录");
                session.setAttribute(ATTRIBUTES_USERID, userId);
                session.setAttribute(ATTRIBUTES_USER, result);
                resultBody.addData("client",result);
            }else {
                resultBody.addError("errors","loginName or password is wrong");
            }
        }else {
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;
    }

//    @PostMapping("/login")
//    @ResponseBody
//    public ModelAndView login( @Valid Client client, Errors errors, HttpSession session){
//        ResultBody resultBody = new ResultBody();
//        if(!errors.hasErrors()){
//            Client result = clientService.login(client);
//            System.out.println(result);
//            if(result!=null){
//                String userId = result.getId();
//                System.out.println(userId+" 登录");
//                session.setAttribute(ATTRIBUTES_USERID, userId);
//                session.setAttribute(ATTRIBUTES_USER, result);
//                resultBody.addData("client",result);
//            }else {
//                resultBody.addError("errors","loginName or password is wrong");
//            }
//        }else {
//            resultBody.addErrors(errors.getAllErrors());
//        }
//        return new ModelAndView("index");
//    }

    @PostMapping("/send")
    public ResultBody sendComplaint(@RequestBody @Valid Complaint complaint,Errors errors){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            resultBody.addData("complaint",clientService.complain(complaint));
        }
        else{
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;
    }

    @GetMapping("/current")
    @ResponseBody
    public ResultBody getCurrentClient(HttpSession httpSession){
        ResultBody resultBody = new ResultBody();
        Client client = (Client) httpSession.getAttribute(ATTRIBUTES_USER);
        if(client==null){
            resultBody.addError("errors","登陸過期，請重新登陸");
            return resultBody;
        }
        resultBody.addData("client",client);
        return resultBody;
    }



}
