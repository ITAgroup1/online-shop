package com.group1.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group1.core.entity.client.Client;
import com.group1.core.entity.comment.Comment;
import com.group1.core.entity.order.Order;
import com.group1.core.entity.order.OrderItem;
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




    public void setItems(Set<OrderItem> items) {
        super.setOrderItems(items);
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

}

