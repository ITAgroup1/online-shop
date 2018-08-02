package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.merchant.service.MerchantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Resource(name = "merchantService")
    private MerchantService merchantService;

    @PostMapping("/register")
    public Merchant saveMerchant(Merchant merchant) {
        return merchantService.save(merchant);
    }
}
