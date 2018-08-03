package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.ShopService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@SessionAttributes("merchant")
public class ShopController {

    @Resource(name = "shopService")
    private ShopService shopService;

    @PostMapping("/shop")
    public Shop addShop(Shop shop) {
        return shopService.saveShop(shop);
    }

    @PutMapping("/shop")
    public ResultBody updateShop(@Valid @RequestBody Shop shop, Errors errors) {
        ResultBody resultBody = new ResultBody();
        if(errors.hasErrors()) {
            resultBody.setMessage("Fail to verify");
            resultBody.addErrors(errors.getAllErrors());
        }else {
            resultBody.setData("shop",shopService.updateShop(shop));
        }
        return resultBody;
    }

    @GetMapping("/shop")
    public ResultBody getShop(@ModelAttribute("merchant") Merchant merchant) {
        ResultBody resultBody = new ResultBody();
        Shop shop = shopService.findByMerchantDetailId(merchant.getId());
        if(shop == null) {
            resultBody.setMessage("Fail to verify");
        }else {
            resultBody.setData("shop", shop);
        }
        return resultBody;
    }
}
