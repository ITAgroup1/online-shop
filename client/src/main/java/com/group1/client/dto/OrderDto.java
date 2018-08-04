package com.group1.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group1.core.entity.client.Client;
import com.group1.core.entity.comment.Comment;
import com.group1.core.entity.order.Order;
import com.group1.core.entity.order.OrderItem;
import com.group1.core.entity.shop.Shop;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

public class OrderDto extends Order implements Serializable {

    /*

     public Set<OrderItem> getItems() {
         return items;
     }

     public void setItems(Set<OrderItem> items) {
         this.items = items;
     }

     public void toOrder(){
         super.setOrderItems(this.getItems());
     }*/

    private Shop shop;

    public void setItems(Set<OrderItem> items) {
        super.setOrderItems(items);
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Order toOrder(){
        Order order = new Order();

        if(this.getShopId()!=null) order.setShopId(this.getShopId());
        if(this.getAddress()!=null) order.setAddress(this.getAddress());
        if(this.getPhone()!=null) order.setPhone(this.getPhone());
        if(this.getCost()!=null) order.setCost(this.getCost());
        if ((this.getOrderTime() != null)) {
            order.setOrderTime(this.getOrderTime());
        } else {
            order.setOrderTime(System.currentTimeMillis());
        }
        if(this.getRemark()!=null) order.setRemark(this.getRemark());
        if(this.getStatus()!=null) order.setStatus(this.getStatus());
        if(this.getComment()!=null) order.setComment(this.getComment());
        if(this.getClient()!=null) order.setClient(this.getClient());
        if(this.getOrderItems()!=null) order.setOrderItems(this.getOrderItems());

        return order;
    }

    public static OrderDto byOrder(Order order){

        OrderDto orderDto = new OrderDto();
        if(order.getId()!=null) orderDto.setId(order.getId());
        if(order.getShopId()!=null) orderDto.setShopId(order.getShopId());
        if(order.getAddress()!=null) orderDto.setAddress(order.getAddress());
        if(order.getPhone()!=null) orderDto.setPhone(order.getPhone());
        if(order.getCost()!=null) orderDto.setCost(order.getCost());
        if ((order.getOrderTime() != null)) {
            orderDto.setOrderTime(order.getOrderTime());
        } else {
            orderDto.setOrderTime(System.currentTimeMillis());
        }
        if(order.getRemark()!=null) orderDto.setRemark(order.getRemark());
        if(order.getStatus()!=null) orderDto.setStatus(order.getStatus());
        if(order.getComment()!=null) orderDto.setComment(order.getComment());
        if(order.getClient()!=null) orderDto.setClient(order.getClient());
        if(order.getOrderItems()!=null) orderDto.setOrderItems(order.getOrderItems());

        return orderDto;
    }

}

