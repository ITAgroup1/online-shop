package com.group1.merchant.service;

import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.Message;
import com.group1.core.utils.PropertiesUtils;
import com.group1.core.utils.jerseyPoolingClientFactory.JerseyPoolingClientFactoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ShopServiceTest {

    @Resource
    private ShopService shopService;

    @Resource
    private JerseyPoolingClientFactoryImpl jerseyPoolingClientFactoryBean;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        Shop shop = new Shop();
        shop.setShopName("hah");
        shop.setAddress("123");
        shop.setDistributionCost(23.00);
        shop.setBusinessPic("123");
        shop.setShopPic(new HashSet<>());

//        Recipe recipe = new Recipe();
//        Set<Recipe> recipeSet = new HashSet<>();
//        shop.setRecipes(recipeSet);
//        recipe.setShop(shop);
//        recipeSet.add(recipe);

        shopService.saveShop(shop);
    }

    @Test
    public void testJersey() throws Exception {
        String clientId = "8a5e9d1565001b770165001b7e380000";
        String shopId = "8a5e9d1564ffe33e0164ffe344650000";
        String orderId = "8a5e9d156503bf6a016503bfe1810000";
        Message message = new Message(shopId,clientId);

        Map<String, Object> map = new HashMap<>();
        map.put("status", 2);
        map.put("orderId", orderId);
        message.setMap(map);

        javax.ws.rs.client.Client client = jerseyPoolingClientFactoryBean.getObject();
        WebTarget webTarget = client.target(PropertiesUtils.getProperty("client_ws_url"));
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        String str = JsonUtil.objectToJson(message);
        Response response = invocationBuilder.post(Entity.entity(str,MediaType.APPLICATION_JSON_TYPE));
        System.out.println(response.getStatus());
        System.out.println(response);
    }
}