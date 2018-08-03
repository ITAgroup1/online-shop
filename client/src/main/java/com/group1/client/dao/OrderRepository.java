package com.group1.client.dao;

import com.group1.core.entity.order.Order;
import com.group1.core.utils.base.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
    Order update(String orderId,Integer status);

}
