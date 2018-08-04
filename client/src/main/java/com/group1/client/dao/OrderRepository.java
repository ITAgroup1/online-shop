package com.group1.client.dao;

import com.group1.core.entity.order.Order;
import com.group1.core.utils.base.JpaRepository;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;

public interface OrderRepository extends JpaRepository<Order,String> {
    Order update(String orderId,Integer status);
    Page<Order> findAllById(String clientId, Pageable pageable);

}
