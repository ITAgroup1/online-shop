package com.group1.client.dao.impl;

import com.group1.client.dao.OrderRepository;
import com.group1.core.entity.order.Order;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("orderRepository")
public class OrderRepositoryImpl extends JPARepositoryImpl<Order,String> implements OrderRepository {

    @Override

    public Order update(String orderId, Integer status) {
        Order result = entityManager.find(Order.class,orderId);
        result.setStatus(status);
        entityManager.persist(result);
        return result;
    }
}
