package com.group1.client.dao;

import com.group1.core.entity.client.Client;
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
public class ClientRepositoryTest {

    @Resource(name = "clientRepository")
    private ClientRepository clientRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void change() {
        String id = "8a5e9d1764f8a21c0164f8a220920000";
        Client client = new Client();
        client.setLoginName("joy1");
        client.setPassword("23456");
        client.setAddress("here");
        client.setPhone("16579380928");
        Assert.assertNotNull(clientRepository.change(client,id));

    }

    @Test
    public void login() {
        String loginName = "joy2222";
        String password = "123456";
        Assert.assertNotNull(clientRepository.login(loginName,password));
    }

    @Test
    public void testRegister(){
        Client client = new Client();
        client.setLoginName("joy2222");
        client.setPassword("123456");
        Assert.assertNotNull(clientRepository.save(client));
    }
}