package com.group1.merchant.dao.impl;


import com.group1.merchant.dao.MerchantDetailRepository;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository("merchantDetailRepository")
public class MerchantDetailRepositoryImpl extends JPARepositoryImpl<MerchantDetail,String> implements MerchantDetailRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public MerchantDetail getMerchantDetailByShopId(String shopId) {
        Query query = entityManager.createQuery("select c from MerchantDetail c where c.shopId=:shopId");
        query.setParameter("shopId",shopId);
        List<MerchantDetail> list = query.getResultList();
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}
