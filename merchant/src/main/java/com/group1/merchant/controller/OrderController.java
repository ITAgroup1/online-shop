package com.group1.merchant.controller;

import com.group1.core.entity.order.Order;
import com.group1.core.handler.SpringWebSocketHandler;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.Message;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.OrderSerivce;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/merchant/order")
public class OrderController {

    @Resource
    private OrderSerivce orderService;

    @Bean   // 这个注解会从Spring容器拿出Bean
    public SpringWebSocketHandler infoHandler() {
        return new SpringWebSocketHandler();
    }

    // 給客戶端調用的接口
    @PostMapping("/websocket")
    @ResponseBody
    public ResultBody send(Message message) {
        ResultBody resultBody = new ResultBody();
        Map<String, Object> map = message.getMap();
        String orderId = (String) map.get("");
        Integer status = Integer.valueOf((String) map.get(""));
        Order order = orderService.update(orderId, status);
        message.getMap().put("status", order.getStatus().toString());
        String str = JsonUtil.objectToJson(order);
        infoHandler().sendMessageToUser(message.getReceiverId(), new TextMessage(str));
        resultBody.addData("result", "success send");
        return resultBody;
    }
}
