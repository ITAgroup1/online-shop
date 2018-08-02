package com.group1.client.service;

import com.group1.core.entity.client.Client;

public interface ClientService {
    Client update(Client client);

    Client register(Client client);

    Client login(String loginName,String password);
}
