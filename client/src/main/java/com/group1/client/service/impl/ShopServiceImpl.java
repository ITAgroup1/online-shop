package com.group1.client.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group1.client.dao.ShopRepository;
import com.group1.client.service.ShopService;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.ResultBody;
import com.group1.core.utils.jerseyPoolingClientFactory.JerseyPoolingClientFactoryImpl;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.PropertiesUtils;
import com.group1.core.utils.jerseyPoolingClientFactory.JerseyPoolingClientFactroy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private JerseyPoolingClientFactroy jerseyPoolingClientFactoryBean;

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
            ResultBody resultBody = JsonUtil.jsonToObject(str, ResultBody.class);

            if(ResultBody.STATUS_SUCCESS.equals(resultBody.getStatus())){

                ObjectMapper mapper = new ObjectMapper();
                List<String> ids = (List<String>)resultBody.getData("shops");

                List<Shop> shops = (List<Shop>) shopRepository.findAll(ids);

                return shops;
            }

            return null;

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
        Shop shop = shopRepository.findOne(shopId);
        shop.getRecipes();
        return shop;
    }
}
