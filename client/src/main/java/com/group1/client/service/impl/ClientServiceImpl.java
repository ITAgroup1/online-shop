package com.group1.client.service.impl;

import com.group1.client.dao.ClientRepository;
import com.group1.client.service.ClientService;
import com.group1.core.entity.client.Client;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("clientService")

public class ClientServiceImpl implements ClientService {

    @Resource
    private ClientRepository clientRepository;

    @Override
    public Client login(String loginName, String password) {
        return clientRepository.login(loginName,password);
    }

    @Override
    public Client update(Client client,String id) {
        return clientRepository.change(client,id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }
}
