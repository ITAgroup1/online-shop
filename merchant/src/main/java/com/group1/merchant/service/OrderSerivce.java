package com.group1.merchant.service;

import com.group1.core.entity.order.Order;

import java.util.List;

public interface OrderSerivce {
    Order update(String orderId, Integer status);
    List<Order> listOrderByMerchantId(String merchantId);
}
