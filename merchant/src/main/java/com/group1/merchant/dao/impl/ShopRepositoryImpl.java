package com.group1.merchant.dao.impl;

import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import com.group1.merchant.dao.ShopRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("shopRepository")
public class ShopRepositoryImpl extends JPARepositoryImpl<Shop,String> implements ShopRepository {

    @Override
    public Shop update(Shop shop) {
        entityManager.persist(shop);
        return shop;
    }

    @Override
    public Shop findByMerchantDetailId(String merchantDetailId) {
        String jsql = "select s from Shop s where s.merchantDetailId =:mdId";
        Query query = entityManager.createQuery(jsql);
        query.setParameter("mdId", merchantDetailId);
        List<Object> shops = query.getResultList();
        if(shops == null || shops.isEmpty()) return null;
        Shop shop = (Shop) shops.get(0);
        return shop;
    }
}
