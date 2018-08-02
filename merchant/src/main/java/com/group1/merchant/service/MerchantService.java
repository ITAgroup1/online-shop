package com.group1.merchant.service;

import com.group1.core.entity.merchant.Merchant;

public interface MerchantService {
    Merchant save(Merchant merchant);
    Merchant findById(String merchantId);
}
