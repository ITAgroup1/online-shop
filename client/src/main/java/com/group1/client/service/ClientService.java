package com.group1.client.service;

import com.group1.core.entity.client.Client;
import com.group1.core.entity.complaint.Complaint;
import com.group1.core.utils.ResultBody;

public interface ClientService {
    Client update(Client client,String id);

    Client save(Client client);

    Client login(Client client);

    Complaint complain(Complaint complaint);

    Client findClientByLoginName(String loginName);
}
