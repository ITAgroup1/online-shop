package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.order.Order;
import com.group1.core.handler.SpringWebSocketHandler;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.Message;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.MerchantDetailService;
import com.group1.merchant.service.OrderSerivce;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/merchant/order")
public class OrderController {

    @Resource
    private OrderSerivce orderService;

    @Resource
    private MerchantDetailService merchantDetailService;

    @Bean   // 这个注解会从Spring容器拿出Bean
    public SpringWebSocketHandler infoHandler() {
        return new SpringWebSocketHandler();
    }

    // 給客戶端調用的接口
    @PostMapping("/websocket")
    @ResponseBody
    public ResultBody send(@RequestBody Message message) {
        ResultBody resultBody = new ResultBody();
        Map<String, Object> map = message.getMap();
        String orderId = (String) map.get("orderId");
        Integer status = (Integer) map.get("status");
        Order order = orderService.update(orderId, status);
        message.getMap().put("status", order.getStatus().toString());
        String str = JsonUtil.objectToJson(order);
        System.out.println("merchant :");
        System.out.println(str);
        String shopId = message.getReceiverId();
        Merchant merchant = merchantDetailService.getMerchantDetail(shopId);
        infoHandler().sendMessageToUser(merchant.getId(), new TextMessage(str));
        resultBody.addData("result", "success send");
        return resultBody;
    }

    @ResponseBody
    @RequestMapping
    public ResultBody orderList(HttpSession httpSession){
        Merchant merchant = (Merchant) httpSession.getAttribute("merchant");
        ResultBody resultBody = new ResultBody();

        if(merchant==null){
            resultBody.addError("errors","請重新登陸");
        }else {
            List<Order> orders = orderService.listOrderByMerchantId(merchant.getId());
            resultBody.addData("orderList",orders);
        }
        return resultBody;
    }
}
