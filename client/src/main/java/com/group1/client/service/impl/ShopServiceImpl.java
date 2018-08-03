package com.group1.client.service.impl;

import com.group1.client.dao.ShopRepository;
import com.group1.client.service.ShopService;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.JerseyPoolingClientFactoryBean;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.PropertiesUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private JerseyPoolingClientFactoryBean jerseyPoolingClientFactoryBean;

    @Resource
    private ShopRepository shopRepository;

    @Override
    public List<Shop> list() {
        try {
            String url = PropertiesUtils.getProperty("jersey_url");
            javax.ws.rs.client.Client client = jerseyPoolingClientFactoryBean.getObject();

            WebTarget webTarget = client.target(url);
            Response response = webTarget.request().get();
            String str = response.readEntity(String.class);
            List<String> ids = (List<String>) JsonUtil.jsonToObject(str, List.class);

            return (List<Shop>) shopRepository.findAll(ids);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop findOne(String shopId) {
        return shopRepository.findOne(shopId);
    }
}
