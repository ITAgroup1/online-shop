package com.group1.merchant.service.impl;

import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.dao.ShopRepository;
import com.group1.merchant.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopRepository shopRepository;

    @Override
    @Transactional

    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    @Transactional
    public Shop updateShop(Shop shop) {
        Shop sp = shopRepository.findOne(shop.getId());
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
        shopRepository.update(sp);
        return sp;
    }

    @Override
    @Transactional
    public Shop findByShopId(String shop_id) {
        return null;
    }

    @Override
    @Transactional
    public Shop findByMerchantDetailId(String merchantDetailId) {

        return shopRepository.findByMerchantDetailId(merchantDetailId);
    }
}
