package com.group1.client.dao.impl;

import com.group1.client.dao.RecipeRepository;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.base.model.Pageable;
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
public class RecipeRepositoryImplTest {

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

    @Test
    public void getAllByShopId(){
        String shopId = "1";
        Pageable pageable = new Pageable();
        pageable.setOffset(1);
        pageable.setSize(2);
        System.out.println(recipeRepository.listByShopId(shopId,pageable));
    }
}