package com.group1.merchant.service.impl;

import com.group1.core.entity.order.Order;
import com.group1.merchant.service.OrderSerivce;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderSerivce {

    @Override
    public Order update(String orderId, Integer status) {
        return null;
    }
}
