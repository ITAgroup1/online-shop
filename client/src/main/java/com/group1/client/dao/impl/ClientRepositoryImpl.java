package com.group1.client.dao.impl;

import com.group1.client.dao.ClientRepository;
import com.group1.core.entity.client.Client;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

@Repository(value = "clientRepository")
public class ClientRepositoryImpl extends JPARepositoryImpl<Client,String> implements ClientRepository {


    @Override
    @Transactional
    public Client change(Client client,String id) {
        Client result = entityManager.find(Client.class,id);
        result.setLoginName(client.getLoginName());
        result.setPhone(client.getPhone());
        result.setPassword(client.getPassword());
        result.setAddress(client.getAddress());
        entityManager.persist(result);
        return result;
    }

    @Override
    public Client login(Client client) {
        Query query = entityManager.createQuery("select c from Client c where c.loginName=:loginName and c.password=:password");
        query.setParameter("loginName",client.getLoginName());
        query.setParameter("password",client.getPassword());
        Client c = (Client) query.getSingleResult();
        return c;

    }




}
