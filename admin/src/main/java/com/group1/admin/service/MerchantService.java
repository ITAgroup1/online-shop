package com.group1.admin.service;

import com.group1.core.entity.merchant.Merchant;

public interface MerchantService {
    public Merchant register(Merchant merchant);

    public Merchant login(Merchant merchant);

    public Merchant getMerchantByshopId(String shopId);
}
