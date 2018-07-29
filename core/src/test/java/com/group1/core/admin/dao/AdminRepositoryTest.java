package com.group1.core.admin.dao;

import com.group1.core.admin.model.Admin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.Table;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class AdminRepositoryTest {

    @Resource
    private AdminRepository adminRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        System.out.println(adminRepository);
        System.out.println(adminRepository.getClass());
    }

    @Test
    public void test1(){
        Admin admin = new Admin();
        admin.setLoginName("tony");
        admin.setPassword("123456");
        adminRepository.save(admin);
    }
}