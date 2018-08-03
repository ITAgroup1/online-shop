package com.group1.merchant.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.group1.core.entity.complaint.Complaint;
import com.group1.core.utils.JerseyPoolingClientFactoryBean;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.PropertiesUtils;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.ComplaintService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.client.Client;
import java.util.List;

@Service("complaintService")
public class ComplaintServiceImpl implements ComplaintService {

    @Resource
    private JerseyPoolingClientFactoryBean jerseyPoolingClient;

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
