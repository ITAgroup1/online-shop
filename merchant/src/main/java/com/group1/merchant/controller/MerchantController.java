package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.annotation.NoLogin;
import com.group1.merchant.service.MerchantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

    @Resource(name = "merchantService")
    private MerchantService merchantService;

    @NoLogin
    @PostMapping("/login")
    @ResponseBody
    public ResultBody merchantLogin(@RequestBody Merchant merchant, HttpSession session) {
        ResultBody resultBody = merchantService.merchantLogin(merchant);
        session.setAttribute("merchant", JsonUtil.mapToObject((Map) resultBody.getData("merchant"),Merchant.class));
        return resultBody;
    }

    @NoLogin
    @PostMapping("/register")
    @ResponseBody
    public ResultBody merchantRegister(@RequestBody Merchant merchant, HttpSession session) {
        ResultBody resultBody = merchantService.merchantRegister(merchant);
        session.setAttribute("merchant", JsonUtil.mapToObject((Map) resultBody.getData("merchant"),Merchant.class));
        return resultBody;
    }


}
