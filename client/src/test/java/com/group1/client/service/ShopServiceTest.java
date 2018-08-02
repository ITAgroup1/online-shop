package com.group1.client.service;

import com.group1.core.entity.shop.model.Shop;
import com.group1.core.utils.base.model.Pageable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class ShopServiceTest {

    private Pageable pageable;

    @Resource
    private ShopService shopService;

    @Before
    public void setUp() throws Exception {
        pageable = new Pageable(1,2);

    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void getAll() {
        shopService.getAll(pageable);
    }


}