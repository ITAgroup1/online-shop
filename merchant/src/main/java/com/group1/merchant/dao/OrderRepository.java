package com.group1.merchant.dao;

import com.group1.core.entity.order.Order;
import com.group1.core.utils.base.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {
    Order update(String orderId, Integer status);
    List<Order> list(String merchantId);
}
