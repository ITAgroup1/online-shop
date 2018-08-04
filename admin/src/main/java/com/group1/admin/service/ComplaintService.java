package com.group1.admin.service;

import com.group1.core.entity.complaint.Complaint;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;

import java.util.List;

public interface ComplaintService {
    public Complaint add(Complaint complaint);

    public Page<Complaint> listAll(Pageable pageable);

    public Complaint updateStatus(String id, Integer status);

    public List<Complaint> listToMerchant(String merchantId);
}
