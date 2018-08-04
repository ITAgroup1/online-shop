package com.group1.admin.dao;

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
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MerchantRepositoryTest {

    @Resource(name="merchantDao")
    private MerchantRepository merchantRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        Merchant merchant = new Merchant();
        merchant.setLoginName("jackyX");
        merchant.setPassword("123456");
        Merchant m2=merchantRepository.save(merchant);
        assertNotNull(m2);
        System.out.println(m2.getId());
    }

    @Test
    public void login() throws Exception {
        String loginName = "jackyX";
        String password ="123456";
        Merchant m=merchantRepository.login(loginName,password);
        assertNotNull(m);
        System.out.println(m.getId());
    }

    @Test
    public void testCheckUnipue(){
        String loginName = "jackyX";
        Merchant merchant=merchantRepository.checkUnipue(loginName);
        assertNotNull(merchant);
        System.out.println(merchant);
    }
}