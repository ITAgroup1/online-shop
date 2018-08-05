package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Resource(name = "complaintService")
    private ComplaintService complaintService;

    @GetMapping
    public ResultBody getComplaints(HttpSession session) {
        Merchant merchant = (Merchant) session.getAttribute("merchant");
        if(merchant == null) {
            return null;
        }
        ResultBody resultBody = complaintService.getComplaints(merchant.getId());
        return resultBody;
    }
}
