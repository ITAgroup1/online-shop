package com.group1.client.dao.impl;

import com.group1.client.dao.OrderRepository;
import com.group1.core.entity.order.Order;
import com.group1.core.entity.order.OrderItem;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import com.group1.core.utils.base.model.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository("orderRepository")
public class OrderRepositoryImpl extends JPARepositoryImpl<Order,String> implements OrderRepository {

    @Override
    public Order update(String orderId, Integer status) {
        Order result = entityManager.find(Order.class,orderId);
        result.setStatus(status);
        entityManager.persist(result);
        return result;
    }

    @Override
    public Page<Order> findAllById(String clientId, Pageable pageable) {

        Query query = entityManager.createQuery("select o from Order o where o.client.id=:clientId order by o.orderTime desc")
                .setFirstResult((pageable.getOffset() - 1) * pageable.getSize())
                .setMaxResults(pageable.getSize());
        query.setParameter("clientId",clientId);
        Query query1 = entityManager.createQuery("select count(1) from Order o where o.client.id=:clientId");
        query1.setParameter("clientId",clientId);
        Integer count = Integer.valueOf(String.valueOf(query1.getSingleResult()));
        List<Order> data = query.getResultList();
        Page<Order> page = new Page<>();
        page.setData(data); // 分页数据
        page.setOffset(pageable.getOffset()); // 当前页数
        page.setSize(data.size());  //当前页面行数
        page.setTotalSize(count); //总行数
        return page;
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(String orderId){
        Query query = entityManager.createQuery("select o from OrderItem o where o.order.id=:orderId ");
        query.setParameter("orderId",orderId);
        return query.getResultList();
    }
}
