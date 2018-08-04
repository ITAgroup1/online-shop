package com.group1.admin.service.impl;

import com.group1.admin.dao.MerchantRepository;
import com.group1.admin.service.MerchantService;
import com.group1.core.entity.merchant.Merchant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("merchantService")
public class MerchanServiceImpl implements MerchantService {

    @Resource(name = "merchantDao")
    private MerchantRepository merchantRepository;

    @Override
    @Transactional
    public Merchant register(Merchant merchant) {
        if (merchantRepository.checkUnipue(merchant.getLoginName()) == null) {
            Merchant m = merchantRepository.save(merchant);
            return m != null ? m : null;
        } else {
            return null;
        }
    }

    @Override
    public Merchant login(Merchant merchant) {
        return merchantRepository.login(merchant.getLoginName(), merchant.getPassword());
    }
}
