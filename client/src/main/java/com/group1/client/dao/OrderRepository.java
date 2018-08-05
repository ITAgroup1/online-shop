package com.group1.client.dao;

import com.group1.core.entity.order.Order;
import com.group1.core.entity.order.OrderItem;
import com.group1.core.utils.base.JpaRepository;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {
    Order update(String orderId,Integer status);
    Page<Order> findAllById(String clientId, Pageable pageable);
    List<OrderItem> getOrderItemsByOrderId(String orderId);
}
