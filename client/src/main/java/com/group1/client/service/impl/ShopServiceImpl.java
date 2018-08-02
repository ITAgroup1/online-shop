package com.group1.client.service.impl;

import com.group1.client.dao.ShopRepository;
import com.group1.client.service.ShopService;
import com.group1.core.entity.shop.model.Shop;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopRepository shopRepository;

    @Override
    public Page<Shop> getAll(Pageable pageable) {

        return shopRepository.findAll(pageable);
    }
}
