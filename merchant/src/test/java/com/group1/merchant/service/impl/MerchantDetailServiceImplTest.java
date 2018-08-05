package com.group1.merchant.service.impl;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.merchant.service.MerchantDetailService;
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
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MerchantDetailServiceImplTest {

    @Resource(name = "merchantDetailService")
    private MerchantDetailService merchantDetailService;

    private MerchantDetail merchantDetail;
    private Merchant merchant;
    @Before
    public void before() {
        merchantDetail = new MerchantDetail();
        merchantDetail.setStatus(MerchantDetail.UNTREATED);
        merchantDetail.setAddress("Test 5");
        merchantDetail.setIdcardNum("123456789012345678");
        merchantDetail.setIntroduction("Test Intruce4");
        merchantDetail.setMerchantName("Test MerName4");
        merchantDetail.setIdcardPic("testUrl");
        Set<String> shopPiceset =  new HashSet<>();
        shopPiceset.add("test pc et");
        shopPiceset.add("test pic st");
        shopPiceset.add("test pc se");
        merchantDetail.setShopPic(shopPiceset);
        merchantDetail.setBusinessPic("bussiner pic255");
        merchantDetail.setShopId("opIdI47");
        merchant = new Merchant();
        merchant.setId("8a5e9d1864fdd29a0164fdd47a690000");
        merchantDetail.setMerchant(merchant);
    }

    @Test
    public void sendMerchantDetail() {
        merchantDetailService.sendMerchantDetail(merchantDetail);
    }

    @Test
    public void commitMerchantDetail() {
        merchantDetailService.sendMerchantDetail(merchantDetail);
    }

    @Test
    public void modifyMerchantDetail() {
        merchantDetailService.sendMerchantDetail(merchantDetail);
    }

    @Test
    public void verifyMerchantDetail() {
        System.out.println(merchantDetailService.verifyMerchantDetail(merchant));
    }
}