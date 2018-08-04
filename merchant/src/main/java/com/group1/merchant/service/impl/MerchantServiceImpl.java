package com.group1.merchant.service.impl;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.JerseyPoolingClientFactoryBean;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.PropertiesUtils;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.MerchantService;
import org.hibernate.result.ResultSetOutput;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Invocation.Builder;

@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {

    @Resource
    private JerseyPoolingClientFactoryBean jerseyPoolingClient;

    private String adminServer = PropertiesUtils.getProperty("admin.server");

    @Override
    @Transactional
    public ResultBody sendAndReceiveMerchant(Merchant merchant, String serverPath) {
        ResultBody resultBody = null;
        try {
            Client client = jerseyPoolingClient.getObject();
            resultBody = JerseyJsonService.post(client, adminServer, serverPath, merchant, ResultBody.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBody;
    }


    @Override
    public ResultBody merchantLogin(Merchant merchant) {
        String merchantLoginUrl = PropertiesUtils.getProperty("merchant.login.path");
        ResultBody resultBody = sendAndReceiveMerchant(merchant, merchantLoginUrl);
        return resultBody;
    }

    @Override
    public ResultBody merchantRegister(Merchant merchant) {
        String merchantRegisterUrl = PropertiesUtils.getProperty("merchant.register.path");
        ResultBody resultBody = sendAndReceiveMerchant(merchant,merchantRegisterUrl);
        return resultBody;
    }
}
