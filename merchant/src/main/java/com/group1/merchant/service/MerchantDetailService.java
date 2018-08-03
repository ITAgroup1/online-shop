package com.group1.merchant.service;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;

public interface MerchantDetailService {
    MerchantDetail sendMerchantDetail(MerchantDetail merchantDetail);
    MerchantDetail submitMerchantDetail(MerchantDetail merchantDetail);
    MerchantDetail modifyMerchantDetail(MerchantDetail merchantDetails);
    MerchantDetail verifyMerchantDetail(Merchant merchant);
    MerchantDetail getMerchantDetail(Merchant merchant);
}
