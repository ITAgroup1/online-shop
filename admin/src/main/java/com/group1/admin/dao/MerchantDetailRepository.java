package com.group1.admin.dao;

import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.base.JpaRepository;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantDetailRepository  extends JpaRepository<MerchantDetail,String> {
    public MerchantDetail findByMerchatId(String merchantId);
    public MerchantDetail updateStatus(String id, Integer status);
    public Page<MerchantDetail> listToVerify(Pageable pageable);
    public Page<MerchantDetail> listToUpdateStatus(Pageable pageable);
    public List<String> findPaasedShop();
    public MerchantDetail insert(MerchantDetail merchantDetail);
}
