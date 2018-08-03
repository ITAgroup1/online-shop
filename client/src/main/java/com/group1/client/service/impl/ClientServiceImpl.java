package com.group1.client.service.impl;

import com.group1.client.dao.ClientRepository;
import com.group1.client.service.ClientService;
import com.group1.core.entity.client.Client;
import com.group1.core.entity.complaint.Complaint;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.ResultBody;
import com.group1.core.utils.jms.ProducerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service("clientService")

public class ClientServiceImpl implements ClientService {

    @Resource
    private ClientRepository clientRepository;

    @Resource(name = "queueDestination")
    private Destination destination;

    @Resource(name = "producerService")
    private ProducerService producerService;


    @Override
    public Client update(Client client,String id) {
        return clientRepository.change(client,id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client login(Client client) {
        return clientRepository.login(client);
    }

    @Override
    public Complaint complain(Complaint complaint) {
        ResultBody resultBody = new ResultBody();
        resultBody.addData("type","Complaint");
        resultBody.addData("complaint",complaint);
        String complaintJsonString = JsonUtil.objectToJson(resultBody);
        producerService.sendMessage(destination,complaintJsonString);
        return complaint;


    }
}
