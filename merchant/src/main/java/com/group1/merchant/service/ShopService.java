package com.group1.merchant.service;

import com.group1.core.entity.shop.Shop;

public interface ShopService {
    Shop save(Shop shop);
    Shop update(Shop Shop);
    Shop findByShopId(String shopId);
    Shop findByMerchant(String merchantId);
}
