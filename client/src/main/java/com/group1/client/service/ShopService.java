package com.group1.client.service;

import com.group1.core.entity.shop.model.Shop;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;

public interface ShopService {
    Page<Shop> getAll(Pageable pageable);
}
