package com.group1.merchant.service.impl;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.MerchantService;
import com.group1.merchant.service.ShopService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MerchantServiceImplTest {

    @Resource
    private MerchantService merchantService;

    private Merchant merchant;

    @Before
    public void before() {
        merchant = new Merchant();
        merchant.setLoginName("James38");
        merchant.setPassword("123456");
    }

    @Test
    public void sendAndReceiveMerchant() {
        merchantService.sendAndReceiveMerchant(merchant, "merchant");
    }

    @Test
    public void merchantLogin() {
        ResultBody resultBody = merchantService.merchantLogin(merchant);
//        System.out.println(resultBody.getStatus());
//        System.out.println(resultBody.getMessage());
//        System.out.println(resultBody.getData("merchant"));
    }

    @Test
    public void merchantRegister() {
        ResultBody resultBody = merchantService.merchantRegister(merchant);

    }
}