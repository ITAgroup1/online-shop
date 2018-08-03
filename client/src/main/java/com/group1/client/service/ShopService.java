package com.group1.client.service;

import com.group1.core.entity.shop.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> list();
    Shop save(Shop shop);
}
