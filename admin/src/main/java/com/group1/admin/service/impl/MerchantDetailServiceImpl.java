package com.group1.admin.service.impl;

import com.group1.admin.dao.MerchantDetailRepository;
import com.group1.admin.service.MerchantDetailService;
import com.group1.core.entity.merchant.MerchantDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MerchantDetailServiceImpl implements MerchantDetailService {

    @Resource
    private MerchantDetailRepository merchantDetailRepository;

    @Override
    public MerchantDetail add(MerchantDetail merchantDetail) {

        return  merchantDetailRepository.save(merchantDetail);
    }
}
