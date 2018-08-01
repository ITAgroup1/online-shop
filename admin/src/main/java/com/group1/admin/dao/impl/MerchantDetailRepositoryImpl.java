package com.group1.admin.dao.impl;

import com.group1.admin.dao.MerchantDetailRepository;
import com.group1.core.entity.merchant.model.MerchantDetail;
import com.group1.core.utils.base.JpaRepository;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDetailRepositoryImpl extends JPARepositoryImpl<MerchantDetail,String> implements MerchantDetailRepository {

}
