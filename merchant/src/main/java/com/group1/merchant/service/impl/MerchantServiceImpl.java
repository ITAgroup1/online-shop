package com.group1.merchant.service.impl;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.JerseyPoolingClientFactoryBean;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.MerchantService;
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

    @Override
    @Transactional
    public Merchant save(Merchant merchant) {
        Merchant merchant1 = null;
        try {
            Client client = jerseyPoolingClient.getObject();
            String registerUrl = "http://localhost:3000";
//            WebTarget webTarget = client.target(registerUrl);
//            Builder builder = webTarget.request().header("Content-Type", "application/json");
            WebTarget webTarget = client.target(registerUrl).path("merchant");



            Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON_TYPE);
            Response response = invocationBuilder.post(Entity.entity(merchant, MediaType.APPLICATION_JSON_TYPE));

//            String str = response.readEntity(String.class);
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));

//            String result = response.readEntity(String.class);
//            merchant1 = (Merchant) JsonUtil.jsonToObject(result, Merchant.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return merchant1;
    }

    @Override
    public Merchant findById(String merchantId) {
        return null;
    }
}
