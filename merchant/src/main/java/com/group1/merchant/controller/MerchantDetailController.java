package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.ResultBody;
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
    public ResultBody setUpShop(@RequestBody MerchantDetail merchantDetail, @RequestBody Shop shop, @ModelAttribute("merchant") Merchant merchant) {
        ResultBody resultBody = new ResultBody();

        Shop shop1 = shopService.saveShop(shop);

        merchantDetail.setShopId(shop1.getId());
        merchantDetail.setMerchant(merchant);
        merchantDetail.setStatus(MerchantDetail.UNTREATED);
        merchantDetailService.submitMerchantDetail(merchantDetail);

        return resultBody;
    }

    @PostMapping("/revalidateShop")
    public ResultBody revalidateShop(@ModelAttribute("merchant") Merchant merchant) {
        ResultBody resultBody = new ResultBody();
        MerchantDetail merchantDetail = merchantDetailService.getMerchantDetail(merchant);
        merchantDetailService.modifyMerchantDetail(merchantDetail);
        return resultBody;
    }
}
