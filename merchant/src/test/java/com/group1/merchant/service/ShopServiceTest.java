package com.group1.merchant.service;

import com.group1.core.entity.shop.Shop;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ShopServiceTest {

    @Resource
    private ShopService shopService;

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
}