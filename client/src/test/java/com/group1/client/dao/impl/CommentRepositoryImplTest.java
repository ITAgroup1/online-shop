package com.group1.client.dao.impl;

import com.group1.client.dao.CommentRepository;
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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class CommentRepositoryImplTest {

    @Resource(name="commentRepository")
    private CommentRepository commentRepository;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCommit(){
        Comment comment = new Comment();
        comment.setShopId("opIdI47");
        comment.setScore(2);
        comment.setContent("jicha");
        comment.setCommentTime(System.currentTimeMillis()-1000*3600*10);

        Assert.assertNotNull(commentRepository.save(comment));
    }

    @Test
    public void testList(){
        List<Comment> comments = commentRepository.getAllByShopId("opIdI47");
        comments.forEach( comment -> System.out.println(comment.toString()));
    }
}