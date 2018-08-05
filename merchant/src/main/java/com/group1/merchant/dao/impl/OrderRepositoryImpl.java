package com.group1.merchant.dao.impl;

import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.entity.order.Order;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import com.group1.merchant.dao.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("orderRepository")
public class OrderRepositoryImpl extends JPARepositoryImpl<Order, String> implements OrderRepository {

    @Override
    public Order update(String orderId, Integer status) {
        Order result = entityManager.find(Order.class, orderId);
        result.setStatus(status);
        entityManager.persist(result);
        return result;
    }

    public List<Order> list(String shopId) {
        String jqlOrder = "select o from Order o where o.shopId = :shopId order by orderTime desc";
        Query shopQuery = entityManager.createQuery(jqlOrder);
        shopQuery.setParameter("shopId", shopId);
        return shopQuery.getResultList();
    }
}
