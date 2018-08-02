package com.group1.client.dao.impl;

import com.group1.client.dao.ShopRepository;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class ShopRepositoryImpl extends JPARepositoryImpl<Shop,String> implements ShopRepository {

}
