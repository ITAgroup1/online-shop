package com.group1.admin.dao;

import com.group1.core.entity.merchant.model.MerchantDetail;
import com.group1.core.utils.base.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantDetailRepository  extends JpaRepository<MerchantDetail,String> {

}
