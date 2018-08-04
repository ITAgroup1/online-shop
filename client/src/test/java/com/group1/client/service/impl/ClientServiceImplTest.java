package com.group1.client.service.impl;

import com.group1.client.dao.ClientRepository;
import com.group1.core.entity.client.Client;
import com.group1.core.entity.comment.Comment;
import com.group1.core.entity.order.Order;
import com.group1.core.entity.order.OrderItem;
import com.group1.core.entity.recipe.Recipe;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.JerseyPoolingClientFactoryBean;
import com.group1.core.utils.jms.ConsumerService;
import com.group1.core.utils.jms.ProducerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ClientServiceImplTest {

    @Resource
    private ClientRepository clientRepository;

    @Resource
    private JerseyPoolingClientFactoryBean jerseyPoolingClientFactoryBean;

    @Resource
    private ProducerService producerService;

    @Resource
    private ConsumerService consumerService;

    @Resource
    private Destination destination;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void update() {
    }

    @Test
    public void save() {
        Client client = new Client();
        client.setLoginName("tony");
        client.setPassword("123456");
        client.setAddress("ITA");
        client.setPhone("123456");

        Order order = new Order();
        order.setAddress("123");
        order.setCost(12.12);
        order.setRemark("123456");
        order.setStatus(12);
        OrderItem orderItem = new OrderItem();
        orderItem.setCount(12);

        Comment comment = new Comment();
        comment.setScore(12);
        comment.setContent("hah");
//        comment.setOrder(order);
//        order.setComment(comment);

//        Recipe recipe = new Recipe();
//        recipe.setDetail("a meal");
//        recipe.setPrice(12);
//        recipe.setReName("fish");
//        recipe.setRePic("asf");

//        Shop shop = new Shop();
//        shop.setShopName("a shop");
//        recipe.setShop(shop);
//        orderItem.setRecipe(recipe);
        Set<OrderItem> orderItems = new HashSet<>();
        orderItems.add(orderItem);
//        order.setOrderItems(orderItems);

        Set<Order> orders = new HashSet<>();
        orders.add(order);
        orders.add(order);
//        client.setOrders(orders);
//        order.setClient(client);
        clientRepository.save(client);
    }

    @Test
    public void testJerSey() {
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJmsProduct() {

        producerService.sendMessage(destination,"测试消息队列");

    }
}