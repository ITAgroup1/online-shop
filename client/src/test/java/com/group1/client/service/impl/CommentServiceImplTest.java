package com.group1.client.service.impl;

import com.group1.client.service.CommentService;
import com.group1.core.entity.comment.Comment;
import com.group1.core.entity.order.Order;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class CommentServiceImplTest {

    @Resource(name="commentService")
    private CommentService commentService;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void commit() {
        Comment comment = new Comment();
        Order order = new Order();
        order.setId("1");
        order.setShopId("1");
        order.setAddress("here");
        comment.setScore(3);
        comment.setContent("一般");
//        comment.setOrder(order);
        comment.setShopId(order.getShopId());
        Assert.assertNotNull(commentService.commit(comment));


    }
}