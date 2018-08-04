package com.group1.merchant.service.impl;

import com.group1.core.entity.complaint.Complaint;
import com.group1.merchant.service.ComplaintService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ComplaintServiceImplTest {

    @Resource(name = "complaintService")
    private ComplaintService complaintService;

    @Test
    public void getComplaints() {
        complaintService.getComplaints("2");
    }
}