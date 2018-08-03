package com.group1.admin.service.impl;

import com.group1.admin.dao.MerchantDetailRepository;
import com.group1.admin.service.MerchantDetailService;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("merchantDetailService")
public class MerchantDetailServiceImpl implements MerchantDetailService {

    @Resource(name="merchantDetailDao")
    private MerchantDetailRepository merchantDetailRepository;

    @Override
    public MerchantDetail add(MerchantDetail merchantDetail) {

        return  merchantDetailRepository.insert(merchantDetail);
    }

    @Override
    @Transactional
    public MerchantDetail updateStatus(String id, Integer status) {
        return merchantDetailRepository.updateStatus(id,status);
    }

    @Override
    public Page<MerchantDetail> listToVerify(Pageable pageable) {
        return merchantDetailRepository.listToVerify(pageable);
    }

    @Override
    public Page<MerchantDetail> listToUpdateStatus(Pageable pageable) {
        return merchantDetailRepository.listToUpdateStatus(pageable);
    }

    @Override
    public List<String> listPassedShop() {
        return merchantDetailRepository.findPaasedShop();
    }

    @Override
    public MerchantDetail update(MerchantDetail merchantDetail) {
        return merchantDetailRepository.update(merchantDetail);
    }
}
