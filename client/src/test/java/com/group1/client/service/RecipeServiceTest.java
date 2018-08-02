package com.group1.client.service;

import com.group1.core.entity.shop.Shop;
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
public class RecipeServiceTest {

    @Resource(name="recipeService")
    private RecipeService recipeService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAll() {
        Shop shop = new Shop();
        shop.setId("1");
        Assert.assertNotNull(recipeService.getAll(shop.getId()));
    }
}