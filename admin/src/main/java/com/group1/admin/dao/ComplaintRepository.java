package com.group1.admin.dao;

import com.group1.core.entity.complaint.Complaint;
import com.group1.core.utils.base.JpaRepository;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint,String> {

    public List<Complaint> queryDealedComplaint(String shopId);
}
