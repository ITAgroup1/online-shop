package com.group1.admin.service;

import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;

import java.util.List;

public interface MerchantDetailService {

    public MerchantDetail add(MerchantDetail merchantDetail);

    public MerchantDetail updateStatus(String id, Integer status);

    public Page<MerchantDetail> listToVerify(Pageable pageable);

    public Page<MerchantDetail> listToUpdateStatus(Pageable pageable);

    public List<String> listPassedShop();

    public MerchantDetail update(MerchantDetail merchantDetail);
}
