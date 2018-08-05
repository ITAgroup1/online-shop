package com.group1.client.controller;

import com.group1.client.service.ShopService;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.ResultBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping
public class ShopController {

    @Resource
    private ShopService shopService;



    @GetMapping("/shop")
    @ResponseBody
    public ResultBody list(){
        List<Shop> shops = shopService.list();
        ResultBody resultBody = new ResultBody();
        resultBody.addData("shops",shops);
        return resultBody;
    }

    @GetMapping("/shop/{shopId}")
    @ResponseBody
    public ResultBody fineOne(@PathVariable String shopId){
        Shop shop = shopService.findOne(shopId);
        ResultBody resultBody = new ResultBody();
        resultBody.addData("shop",shop);
        return resultBody;
    }

}
