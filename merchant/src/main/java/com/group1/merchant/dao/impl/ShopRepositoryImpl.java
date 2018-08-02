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
        Shop sp = entityManager.find(Shop.class, shop.getId());
        sp.setAddress(shop.getAddress());
        sp.setBusinessPic(shop.getBusinessPic());
        sp.setDistributionCost(shop.getDistributionCost());
        sp.setIntroduction(shop.getIntroduction());
        sp.setMerchantDetailId(shop.getMerchantDetailId());
        sp.setScore(shop.getScore());
        sp.setRecipes(shop.getRecipes());
        sp.setServiceEndTime(shop.getServiceEndTime());
        sp.setServiceStartTime(shop.getServiceStartTime());
        sp.setServiceRange(shop.getServiceRange());
        sp.setShopName(shop.getShopName());
        sp.setShopPic(shop.getShopPic());
        entityManager.persist(sp);
        return sp;
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
