package com.group1.admin.service.impl;

import com.group1.admin.dao.ComplaintRepository;
import com.group1.admin.service.ComplaintService;
import com.group1.core.entity.complaint.Complaint;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("complaintService")
public class ComplaintServiceImpl implements ComplaintService {

    @Resource(name = "complaintDao")
    private ComplaintRepository complaintRepository;

    @Override
    @Transactional
    public Complaint add(Complaint complaint) {
        complaint.setStatus(Complaint.UNTREATED);
        return complaintRepository.save(complaint);
    }

    @Override
    public Page<Complaint> listAll(Pageable pageable) {
        return complaintRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Complaint updateStatus(String id, Integer status) {
        Complaint c = null;
        Complaint complaint = complaintRepository.findOne(id);
        if (complaint != null) {
            complaint.setStatus(status);
            c = complaintRepository.save(complaint);
        }
        return c;
    }

    @Override
    public List<Complaint> listToMerchant(String merchantId) {
        return complaintRepository.queryDealedComplaint(merchantId);
    }
}
