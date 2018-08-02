package com.group1.merchant.dao.impl;


import com.group1.merchant.dao.MerchantDetailRepository;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;


@Repository("merchantDetailRepository")
public class MerchantDetailRepositoryImpl extends JPARepositoryImpl<MerchantDetail,String> implements MerchantDetailRepository {

}
