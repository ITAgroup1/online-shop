package com.group1.merchant.service;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.ResultBody;

public interface MerchantService {
    ResultBody sendAndReceiveMerchant(Merchant merchant, String path);
    ResultBody merchantLogin(Merchant merchant);
    ResultBody merchantRegister(Merchant merchant);
}
