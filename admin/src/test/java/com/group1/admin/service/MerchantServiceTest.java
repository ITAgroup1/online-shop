package com.group1.admin.service;

import com.group1.core.entity.merchant.Merchant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class MerchantServiceTest {

    @Resource(name="merchantService")
    private  MerchantService service;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void registerSucceed() {
        Merchant merchant = new Merchant();
        merchant.setLoginName("jackyU1");
        merchant.setPassword("123456");
        Merchant m2=service.register(merchant);
        assertNotNull(m2);
        System.out.println(m2.getId());
    }

    @Test
    public void registerFailCheckUnipue() {
        Merchant merchant = new Merchant();
        merchant.setLoginName("jacky");
        merchant.setPassword("123456");
        Merchant m2=service.register(merchant);
        assertNull(m2);
        //System.out.println(m2.getId());

    }

    @Test
    public void loginSucceed() {
        Merchant merchant = new Merchant();
        merchant.setLoginName("jacky");
        merchant.setPassword("123456");
        Merchant m=service.login(merchant);
        assertNotNull(m);
        System.out.println(m.getId());
    }

    @Test
    public void loginFail() {
        Merchant merchant = new Merchant();
        merchant.setLoginName("jacky0");
        merchant.setPassword("123456");
        Merchant m=service.login(merchant);
        assertNull(m);
    }

    @Test
    public void findMerchantByshopId() {

        Merchant m=service.getMerchantByshopId("8a5e9d166508f5c7016508ff1dd20000");
        assertNotNull(m);
        System.out.println(m.getLoginName());
    }

}