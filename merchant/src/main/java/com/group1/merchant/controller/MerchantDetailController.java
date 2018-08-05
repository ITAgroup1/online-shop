package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.MerchantDetailService;
import com.group1.merchant.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/merchantDetail")
@SessionAttributes("merchant")
public class MerchantDetailController {

    @Resource(name = "merchantDetailService")
    private MerchantDetailService merchantDetailService;

    @Resource(name = "shopService")
    private ShopService shopService;

    @PostMapping("/setupShop")
    @ResponseBody
    public ResultBody setUpShop(MerchantDetail merchantDetail,Shop shop, @ModelAttribute("merchant") Merchant merchant) {
        ResultBody resultBody = new ResultBody();

        shop.setServiceStartTime((new Date()).getTime());
        shop.setServiceEndTime((new Date()).getTime());
        shop.setScore(0.0);

        Shop shop1 = shopService.saveShop(shop);

        merchantDetail.setShopId(shop1.getId());
        merchantDetail.setMerchant(merchant);
        merchantDetail.setStatus(MerchantDetail.UNTREATED);
        merchantDetailService.submitMerchantDetail(merchantDetail);

        return resultBody;
    }

    @PostMapping("/revalidateShop")
    @ResponseBody
    public ResultBody revalidateShop(@ModelAttribute("merchant") Merchant merchant) {
        ResultBody resultBody = new ResultBody();
        MerchantDetail merchantDetail = merchantDetailService.getMerchantDetail(merchant);
        merchantDetailService.modifyMerchantDetail(merchantDetail);
        return resultBody;
    }

    @GetMapping
    public ModelAndView detail(HttpSession session){
        Merchant merchant = (Merchant) session.getAttribute("merchant");
        MerchantDetail merchantDetail = merchantDetailService.getMerchantDetail(merchant);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("merchantDetail",merchantDetail);
        return mv;
    }
}
