package com.group1.client.dao.impl;

import com.group1.client.dao.ClientRepository;
import com.group1.core.entity.client.Client;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository(value = "clientRepository")
public class ClientRepositoryImpl extends JPARepositoryImpl<Client,String> implements ClientRepository {


    @Override
    @Transactional
    public Client change(Client client,String id) {
        Client result = entityManager.find(Client.class,id);
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
        List<Client> list = query.getResultList();
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }


    }

    @Override
    public Client findClientByLoginName(String loginName) {
        Query query = entityManager.createQuery("select c from Client c where c.loginName=:loginName ");
        query.setParameter("loginName",loginName);
        List<Client> list = query.getResultList();
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }


}
