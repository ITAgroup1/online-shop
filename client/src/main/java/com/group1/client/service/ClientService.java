package com.group1.client.service;

import com.group1.core.entity.client.Client;

public interface ClientService {
    Client update(Client client,String id);

    Client save(Client client);

    Client login(String loginName,String password);
}
