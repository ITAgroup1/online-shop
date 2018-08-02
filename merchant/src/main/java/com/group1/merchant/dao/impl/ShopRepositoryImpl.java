package com.group1.merchant.dao.impl;

import com.group1.core.entity.cmdb.shop.model.Shop;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import com.group1.merchant.dao.ShopRepository;
import org.springframework.stereotype.Repository;

@Repository("shopRepository")
public class ShopRepositoryImpl extends JPARepositoryImpl<Shop,String> implements ShopRepository {

}
