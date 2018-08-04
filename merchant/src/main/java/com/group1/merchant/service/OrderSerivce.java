package com.group1.merchant.service;

import com.group1.core.entity.order.Order;

public interface OrderSerivce {
    Order update(String orderId, Integer status);
}
