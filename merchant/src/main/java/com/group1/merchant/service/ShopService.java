package com.group1.merchant.service;

import com.group1.core.entity.shop.Shop;

public interface ShopService {
    Shop saveShop(Shop shop);
    Shop updateShop(Shop shop);
    Shop findByShopId(String shopId);
    Shop findByMerchantDetailId(String merchantDetailId);
}
