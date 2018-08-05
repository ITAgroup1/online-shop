package com.group1.merchant.dao;


import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.base.JpaRepository;

public interface MerchantDetailRepository extends JpaRepository<MerchantDetail,String> {
    MerchantDetail getMerchantDetailByShopId(String shopId);
}
