package com.group1.client.service;

import com.group1.core.entity.client.model.Client;

public interface ClientService {
    Client update(Client client);

    Client save(Client client);
}
