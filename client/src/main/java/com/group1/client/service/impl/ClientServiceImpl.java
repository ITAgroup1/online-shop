package com.group1.client.service.impl;

import com.group1.client.dao.ClientRepository;
import com.group1.client.service.ClientService;
import com.group1.core.entity.client.Client;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClientServiceImpl implements ClientService {

    @Resource
    private ClientRepository clientRepository;

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public Client register(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client login(String loginName, String password) {
        return clientRepository.login(loginName,password);
    }


}
