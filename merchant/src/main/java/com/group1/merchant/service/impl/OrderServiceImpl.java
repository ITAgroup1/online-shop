package com.group1.merchant.service.impl;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.entity.order.Order;
import com.group1.merchant.dao.OrderRepository;
import com.group1.merchant.service.MerchantDetailService;
import com.group1.merchant.service.OrderSerivce;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.management.Query;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderSerivce {

    @Resource(name = "orderRepository")
    private OrderRepository orderRepository;

    @Resource(name = "merchantDetailService")
    private MerchantDetailService merchantDetailService;

    @Override
    @Transactional
    public Order update(String orderId, Integer status) {
        return orderRepository.update(orderId, status);
    }

    @Override
    public List<Order> listOrderByMerchantId(Merchant merchant){
        MerchantDetail merchantDetail = merchantDetailService.getMerchantDetail(merchant);
        return orderRepository.list(merchantDetail.getShopId());
    }
}
