package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.MerchantDetailService;
import com.group1.merchant.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("merchant")
public class ShopController {

    @Resource(name = "shopService")
    private ShopService shopService;

    @Resource(name = "merchantDetailService")
    private MerchantDetailService merchantDetailService;

    @PutMapping("/shop")
    @ResponseBody
    public ResultBody updateShop(@RequestBody Shop shop, Errors errors) {
        ResultBody resultBody = new ResultBody();
        if (errors.hasErrors()) {
            resultBody.setMessage("Fail to verify");
            resultBody.addErrors(errors.getAllErrors());
        } else {
            resultBody.setData("shop", shopService.updateShop(shop));
        }
        return resultBody;
    }

    @GetMapping("/shop")
    public void getShop(@ModelAttribute("merchant") Merchant merchant, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MerchantDetail merchantDetail = merchantDetailService.getMerchantDetail(merchant);
        if (merchantDetail == null || merchantDetail.getStatus().equals(MerchantDetail.REJECTED)
                || merchantDetail.getStatus().equals(MerchantDetail.NO_PASSED)
                || merchantDetail.getStatus().equals(MerchantDetail.UNTREATED)) {
            request.getRequestDispatcher("/merchantDetail").forward(request,response);
        } else {
            Shop shop = shopService.findByShopId(merchantDetail.getShopId());
            shop.setMerchantDetailId(merchantDetail.getId());
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            request.setAttribute("serviceStartTime", formatter.format(new Date(shop.getServiceStartTime())));
            request.setAttribute("serviceEndTime", formatter.format(new Date(shop.getServiceEndTime())));
            request.setAttribute("shop", shop);
            request.getRequestDispatcher("shopManager").forward(request, response);
        }

    }
}
