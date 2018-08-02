package com.group1.merchant.controller;

import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.ShopService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class ShopController {

    @Resource(name = "shopService")
    private ShopService shopService;

    @PostMapping("/shop")
    public Shop addShop(Shop shop) {
        return shopService.save(shop);
    }

    @PutMapping("/shop")
    public ResultBody updateShop(@Valid Shop shop, Errors errors) {
        ResultBody resultBody = new ResultBody();
        if(errors.hasErrors()) {
            resultBody.setStatus(ResultBody.STATUS_ERROR);
            resultBody.setMessage("Fail to verify");
            resultBody.addErrors(errors.getAllErrors());
        }else {
            resultBody.setStatus(ResultBody.STATUS_SUCCESS);
            resultBody.setData("shop",shopService.update(shop));
        }
        return resultBody;
    }

    @GetMapping("/shop/{merchantDetailId}")
    public ResultBody getShop(@PathVariable String merchantDetailId) {
        ResultBody resultBody = new ResultBody();
        Shop shop = shopService.findByMerchantDetailId(merchantDetailId);
        if(shop == null) {
            resultBody.setStatus(ResultBody.STATUS_ERROR);
            resultBody.setMessage("Fail to verify");
        }else {
            resultBody.setStatus(ResultBody.STATUS_SUCCESS);
            resultBody.setData("shop", shop);
        }
        return resultBody;
    }
}
