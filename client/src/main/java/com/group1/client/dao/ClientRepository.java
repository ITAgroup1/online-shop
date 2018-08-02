package com.group1.client.dao;

import com.group1.core.entity.client.Client;
import com.group1.core.utils.base.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,String> {
    Client change(Client client,String id);
    Client login(String loginName,String password);
}
