package com.group1.client.controller;

import com.group1.client.service.ClientService;
import com.group1.core.entity.client.Client;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Resource(name="clientService")
    private ClientService clientService;

    @PostMapping
    public Client register(Client client){
        return clientService.save(client);
    }

    @PutMapping
    public Client put(Client client,@PathVariable String id){
        return clientService.update(client,id);

    }

    @GetMapping
    public Client login(@PathVariable String loginName,@PathVariable String password){
        return clientService.login(loginName,password);
    }




}
