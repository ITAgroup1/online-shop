package com.group1.client.controller;

import com.group1.client.service.ClientService;
import com.group1.core.entity.client.Client;
import com.group1.core.utils.ResultBody;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public Client put(Client client,@PathVariable String id){

        return clientService.update(client,id);

    }

    @PostMapping("/login")
    @ResponseBody
    public ResultBody login(@Valid Client client,Errors errors){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            resultBody.addData("client",clientService.login(client));
        }else {
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;

    }




}
