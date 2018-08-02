package com.group1.client.controller;

import com.group1.client.service.ShopService;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.ResultBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ShopController {

    @Resource
    private ShopService shopService;



    @GetMapping("/shop")
    @ResponseBody
    public ResultBody list(){
        List<Shop> shops = shopService.list();
        ResultBody resultBody = new ResultBody();
        resultBody.addData("shop",shops);
        return resultBody;
    }

}
