package com.group1.client.dao.impl;

import com.group1.client.dao.ClientRepository;
import com.group1.core.entity.client.Client;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl extends JPARepositoryImpl<Client,String> implements ClientRepository {

}
