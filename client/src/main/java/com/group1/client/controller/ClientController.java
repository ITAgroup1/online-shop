package com.group1.client.controller;

import com.group1.client.service.ClientService;
import com.group1.core.entity.client.Client;
import com.group1.core.entity.complaint.Complaint;
import com.group1.core.utils.ResultBody;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Resource(name="clientService")
    private ClientService clientService;

    @PostMapping("/register")
    @ResponseBody
    public ResultBody register(@Valid Client client,Errors errors){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            resultBody.addData("client",clientService.save(client));
        }else {
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResultBody put(@RequestBody Client client,@PathVariable String id){
        ResultBody resultBody = new ResultBody();
        Client c = clientService.update(client,id);
        resultBody.addData("client",c);
        return resultBody;

    }

    @PostMapping("/login")
    @ResponseBody
    public ResultBody login(@Valid Client client, Errors errors, HttpSession session){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            Client c = clientService.login(client);
            if(c!=null){
                resultBody.addData("client",c);
                session.setAttribute("client",c);
            }else{
                resultBody.addError("errors","loginName or password is wrong");
            }
        }else {
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;

    }

    @RequestMapping("/send")
    public ResultBody sendComplaint(@Valid Complaint complaint,Errors errors){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            resultBody.addData("complaint",clientService.complain(complaint));
        }
        else{
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;
    }




}
