package com.group1.admin.service;

import com.group1.core.entity.admin.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class AdminServiceTest {

    @Resource(name="adminService")
    private AdminService service;

    @Test
    public void login() {
        Admin admin = new Admin();
        admin.setPassword("123456");
        admin.setLoginName("jacky");
        Admin a = service.login(admin);
        assertNotNull(a);
        System.out.println(a);
    }
}