package com.group1.client.service.impl;

import com.group1.client.service.ClientService;
import com.group1.core.entity.client.Client;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class ClientServiceTest1 {

    @Resource(name="clientService")
    private ClientService clientService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void update() {
        String id = "8a5e9d1764f8a21c0164f8a220920000";
        Client client = new Client();
        client.setLoginName("joy123");
        client.setPassword("23456");
        client.setAddress("here");
        client.setPhone("16579380928");
        Assert.assertNotNull(clientService.update(client,id));
    }

    @Test
    public void save() {
        Client client = new Client();
        client.setLoginName("joy2222");
        client.setPassword("123456");
        Assert.assertNotNull(clientService.save(client));
    }

    @Test
    public void login() {
        Client client = new Client();
        client.setLoginName("joy111555");
        client.setPassword("123456");
        Assert.assertNotNull(clientService.login(client));
    }
}