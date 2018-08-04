package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.entity.shop.Shop;
import com.group1.merchant.service.MerchantDetailService;
import com.group1.merchant.service.ShopService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/merchantDetail")
@SessionAttributes("merchant")
public class MerchantDetailController {

    @Resource(name = "merchantDetailService")
    private MerchantDetailService merchantDetailService;

    @Resource(name = "shopService")
    private ShopService shopService;

    @PostMapping("/setupShop")
    public String setUpShop(MerchantDetail merchantDetail, Shop shop) {
        merchantDetailService.submitMerchantDetail(merchantDetail);
        shopService.saveShop(shop);
        return "ApplicationStatusPage";
    }

    @PostMapping("/revalidateShop")
    public String revalidateShop(@ModelAttribute("merchant") Merchant merchant) {
        MerchantDetail merchantDetail = merchantDetailService.getMerchantDetail(merchant);
        merchantDetailService.modifyMerchantDetail(merchantDetail);
        return "ApplicationStatusPage";
    }
}
