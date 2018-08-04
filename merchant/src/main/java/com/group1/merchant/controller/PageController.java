package com.group1.merchant.controller;

import com.group1.merchant.annotation.SessionMerchant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }

    @SessionMerchant
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
