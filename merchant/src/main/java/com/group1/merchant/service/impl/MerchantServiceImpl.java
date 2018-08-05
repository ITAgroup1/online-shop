package com.group1.merchant.service.impl;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.jerseyPoolingClientFactory.JerseyPoolingClientFactoryImpl;
import com.group1.core.utils.PropertiesUtils;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.MerchantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.ws.rs.client.Client;

@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {

    @Resource
    private JerseyPoolingClientFactoryImpl jerseyPoolingClient;

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
