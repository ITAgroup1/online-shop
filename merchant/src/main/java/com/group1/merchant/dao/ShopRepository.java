package com.group1.merchant.dao;

import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.base.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,String> {
    Shop update(Shop shop);
    Shop findByMerchantDetailId(String merchantDetailId);
}

