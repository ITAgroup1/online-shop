package com.group1.merchant.service.impl;

import com.group1.core.utils.jerseyPoolingClientFactory.JerseyPoolingClientFactoryImpl;
import com.group1.core.utils.PropertiesUtils;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.ComplaintService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.client.Client;

@Service("complaintService")
public class ComplaintServiceImpl implements ComplaintService {

    @Resource
    private JerseyPoolingClientFactoryImpl jerseyPoolingClient;

    private String adminServer = PropertiesUtils.getProperty("admin.server");

    @Override
    public ResultBody getComplaints(String merchantId) {
        ResultBody resultBody = null;
        try {
            Client client = jerseyPoolingClient.getObject();
            String complaintGetPath = PropertiesUtils.getProperty("complaint.get.path");
            resultBody = JerseyJsonService.get(client, adminServer, complaintGetPath, merchantId, ResultBody.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBody;
    }
}
