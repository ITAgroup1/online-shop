package com.group1.client.dao.impl;

import com.group1.client.dao.ClientRepository;

import com.group1.core.entity.client.Client;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class ClientRepositoryImpl extends JPARepositoryImpl<Client,String> implements ClientRepository {

    @Override
    public Client login(String loginName, String password) {
        Query query = entityManager.createQuery("select c from Client c where c.name =:loginName and c.password =:password");
        query.setParameter("loginName", loginName);
        query.setParameter("password",password);
        Client client = (Client) query.getSingleResult();
        return client;
    }

    @Override
    public Client update(Client client, String id) {
        Client result = entityManager.find(Client.class,id);
        return null;
    }


}
