package com.group1.client.service.impl;

import com.group1.client.dao.ClientRepository;
import com.group1.client.service.OrderService;
import com.group1.core.entity.client.Client;
import com.group1.core.entity.comment.Comment;
import com.group1.core.entity.order.Order;
import com.group1.core.entity.order.OrderItem;
import com.group1.core.utils.base.model.Pageable;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class OrderServiceImplTest {

    @Resource(name="orderService")
    private OrderService orderService;

    @Resource
    private ClientRepository clientRepository;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void save() {
        Order order = new Order();
        Client client = new Client();
        client.setLoginName("joy4");
        client.setPassword("123456");
        client.setPhone("15113453433");
        client.setAddress("here");
        Client result = clientRepository.save(client);

        Set<OrderItem> items = new HashSet<>();
        OrderItem item1 = new OrderItem();
        OrderItem item2 = new OrderItem();
        item1.setCount(3);
        item1.setRecipeId("1");
        item2.setCount(2);
        item2.setRecipeId("2");
        items.add(item1);
        items.add(item2);

        order.setOrderItems(items);
        order.setShopId("1");
        order.setClient(result);

        Comment comment = new Comment();
        comment.setContent("hehhe");

        order.setCost(200.0);
        order.setRemark("hurry up");
        order.setOrderTime(1233);

        order.setComment(comment);

        Assert.assertNotNull(orderService.save(order));
    }

    @Test
    public void delete() {
        orderService.delete("8a5e9d1764ff14260164ff142cf90001");
    }

    @Test
    public void update() {
        String orderId = "8a5e9d1764ff14260164ff142cf90001";
        Integer status = 2;
        orderService.update(orderId,status);
    }

    @Test
    public void findAll(){
        Pageable pageable = new Pageable();
        pageable.setOffset(1);
        pageable.setSize(2);
        orderService.findAll(pageable);
        System.out.println(orderService.findAll(pageable).getData());
    }
}