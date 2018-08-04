package com.group1.admin.controller;

import com.group1.admin.service.MerchantService;
import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.ResultBody;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Resource(name = "merchantService")
    private MerchantService service;

    @PostMapping("/register")
    @ResponseBody
    public ResultBody register(@Valid @RequestBody Merchant merchant, Errors errors) {
        ResultBody resultBody = new ResultBody();
        if (!errors.hasErrors()) {
            Merchant m = service.register(merchant);
            if (m != null) {
                resultBody.addData("merchant", m);
            } else {
                resultBody.addError("errors", "merchant's loginName is not Unipue");
            }
        } else {
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultBody login(@Valid @RequestBody Merchant merchant, Errors errors) {
        ResultBody resultBody = new ResultBody();
        if (!errors.hasErrors()) {
            Merchant m = service.login(merchant);
            if (m != null) {
                resultBody.addData("merchant", m);
            } else {
                resultBody.addError("errors", "loginName or password is incorrect");
            }
        } else {
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;
    }
}
