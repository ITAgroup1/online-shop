package com.group1.client.service;

import com.group1.client.dto.OrderDto;
import com.group1.core.entity.client.Client;
import com.group1.core.entity.order.Order;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;

public interface OrderService {
    Order save(OrderDto order,Client user);
    Integer delete(String orderId);
    Order update(String orderId,Integer status);
    Page<Order> findAll(Pageable pageable);
    Page<OrderDto> findAllById(String clientId,Pageable pageable);
    OrderDto findOrderDetailByOrderId(String orderId);
}
