package com.group1.core.entity.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "t_order")
public class Order implements Serializable {

    public static final Integer NEW_ORDER = 1;
    public static final Integer ACCEPT_ORDER = 2;
    public static final Integer DELIVER_ORDER = 3;
    public static final Integer FINISH_ORDER = 4;
    public static final Integer REJECTED_ORDER = 5;

    @Id
    @GenericGenerator(name = "ug", strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    private String clientId;
    private String shopId;

    private String address;
    private String phone;
    private Double cost;
    private long orderTime;
    private String remark;
    private Integer status;
    private String commentId;

    @OneToMany(targetEntity=OrderItem.class,cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="oid")
    @JsonIgnore
    private Set<OrderItem> orderItems;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
