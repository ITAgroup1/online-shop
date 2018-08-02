package com.group1.client.dao;

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
public class RecipeRepositoryTest {

    @Resource(name="recipeRepository")
    private RecipeRepository recipeRepository;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAll(){
        Shop shop = new Shop();
        shop.setId("1");
        Assert.assertNotNull(recipeRepository.listAll(shop.getId()));


    }
}