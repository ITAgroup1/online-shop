package com.group1.admin.dao.impl;

import com.group1.admin.dao.ComplaintRepository;
import com.group1.core.entity.complaint.Complaint;
import com.group1.core.utils.base.impl.JPARepositoryImpl;

import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("complaintDao")
public class ComplaintRepositoryImpl extends JPARepositoryImpl<Complaint, String> implements ComplaintRepository {


    @Override
    public List<Complaint> queryDealedComplaint(String merchantId) {
        Query query = entityManager.createQuery("Select C From Complaint C Where C.status =:untreated and C.merchantId =:merchantId");
        query.setParameter("untreated", Complaint.FINISHED);
        query.setParameter("merchantId", merchantId);
        List<Complaint> data = query.getResultList();
        ;
        return data;
    }
}
