package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.merchant.annotation.SessionMerchant;
import com.group1.merchant.service.MerchantDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class PageController {
    @Resource(name = "merchantDetailService")
    private MerchantDetailService merchantDetailService;


    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }

    @SessionMerchant
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/orders")
    public String orders(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Merchant merchant = (Merchant) session.getAttribute("merchant");
        if(checkDetail(merchant, request, response)){
            return "orders";
        }
        return "";
    }

    @RequestMapping("/complaints")
    public String complaints(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Merchant merchant = (Merchant) session.getAttribute("merchant");
        if(checkDetail(merchant, request, response)){
            return "complaints";
        }
        return "";
    }

    private boolean checkDetail(Merchant merchant, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(merchant != null){
            MerchantDetail merchantDetail = merchantDetailService.getMerchantDetail(merchant);
            if (merchantDetail == null || merchantDetail.getStatus().equals(MerchantDetail.REJECTED)
                    || merchantDetail.getStatus().equals(MerchantDetail.NO_PASSED)
                    || merchantDetail.getStatus().equals(MerchantDetail.UNTREATED)) {
                request.getRequestDispatcher("/merchantDetail").forward(request,response);
                return false;
            }
        }else {
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        return true;
    }
}
