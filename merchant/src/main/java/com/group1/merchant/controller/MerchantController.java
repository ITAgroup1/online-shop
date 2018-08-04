package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.MerchantService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/merchant")
@SessionAttributes("merchant")
public class MerchantController {

    @Resource(name = "merchantService")
    private MerchantService merchantService;

    @PostMapping("/login")
    public ResultBody merchantLogin(@RequestBody Merchant merchant, ModelMap map) {
        ResultBody resultBody = merchantService.merchantLogin(merchant);
        map.addAttribute("merchant", resultBody.getData("merchant"));
        return resultBody;
    }

    @PostMapping("/register")
    public ResultBody merchantRegister(@RequestBody Merchant merchant) {
        return merchantService.merchantRegister(merchant);
    }
}
