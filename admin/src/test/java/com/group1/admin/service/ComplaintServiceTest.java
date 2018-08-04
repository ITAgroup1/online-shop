package com.group1.admin.service;

import com.group1.core.entity.complaint.Complaint;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class ComplaintServiceTest {

    @Resource(name = "complaintService")
    private ComplaintService service;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        Complaint complaint = new Complaint();
        complaint.setContent("test content5");
        complaint.setMerchantId("5");
        complaint.setShopId("testshopId5");
        Complaint c = service.add(complaint);
        assertNotNull(c);
    }

    @Test
    public void listAll() {
        Pageable pageable = new Pageable(1, 10);
        Page<Complaint> page = service.listAll(pageable);
        assertNotNull(page);
        System.out.println(page);
    }

    @Test
    public void updateStatus() {
        String id = "8a5e9d1864fefa700164fefce8b50001";
        Integer status = Complaint.DEALING;
        Complaint c = service.updateStatus(id, status);
        assertNotNull(c);
        System.out.println(c.getStatus());
    }

    @Test
    public void listToMerchant() {

        List<Complaint> page = service.listToMerchant("2");
        assertNotNull(page);
        System.out.println(page.size());
    }
}