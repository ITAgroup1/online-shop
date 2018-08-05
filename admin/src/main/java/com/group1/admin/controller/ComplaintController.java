package com.group1.admin.controller;

import com.group1.admin.service.ComplaintService;
import com.group1.core.entity.complaint.Complaint;
import com.group1.core.utils.ResultBody;
import com.group1.core.utils.base.model.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 100000)
public class ComplaintController {

    @Resource(name = "complaintService")
    private ComplaintService service;

    @GetMapping(value="/complaint/{shopId}")
    @ResponseBody
    public ResultBody getComplaints(@PathVariable String shopId) {
        ResultBody resultBody = new ResultBody();
        if (shopId == null) {
            resultBody.addError("errors", "merchantId is null");
        } else {
            resultBody.setStatus("1");
            List<Complaint> complaints = service.listToMerchant(shopId);
            resultBody.addData("complaints", complaints);
        }
        return resultBody;
    }

    @GetMapping("/admin/complaint/list")
    @ResponseBody
    public ResultBody getAll(Pageable pageable) {
        pageable = pageable != null ? pageable : new Pageable(1, 10);
        ResultBody resultBody = new ResultBody();
        resultBody.addData("list", service.listAll(pageable));
        return resultBody;
    }

    @PutMapping(value = "/admin/complaint/{id}/{status}")
    @ResponseBody
    public ResultBody updateStatus(@PathVariable String id, @PathVariable Integer status) {
        ResultBody resultBody = new ResultBody();
        if (id != null && status != null) {
            Complaint c = service.updateStatus(id, status);
            if (c != null) {
                resultBody.setStatus(resultBody.STATUS_SUCCESS);
                resultBody.addData("complaint", c);
            } else {
                resultBody.setStatus(resultBody.STATUS_ERROR);
                resultBody.setMessage("Fail to update status");
            }
        } else if (id == null) {
            resultBody.addError("errors", "id is null");
        } else if (status == null) {
            resultBody.addError("errors", "status is null");
        }
        return resultBody;
    }
}
