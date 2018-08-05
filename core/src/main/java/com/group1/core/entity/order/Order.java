package com.group1.core.entity.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.group1.core.entity.client.Client;
import com.group1.core.entity.comment.Comment;
import com.group1.core.utils.JsonUtil;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "t_order")
public class Order implements Serializable , Cloneable {

    public static final Integer NEW_ORDER = 1;
    public static final Integer ACCEPT_ORDER = 2;
    public static final Integer DELIVER_ORDER = 3;
    public static final Integer FINISH_ORDER = 4;
    public static final Integer REJECTED_ORDER = 5;

    @Id
    @GenericGenerator(name = "ug", strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    @Column(name = "shop_id")
    private String shopId;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private Double cost;

    @Column
    private Long orderTime;

    @Column
    private String remark;

    @Column
    private Integer status;

    @OneToOne(targetEntity = Comment.class,cascade = CascadeType.ALL)
    @JoinColumn(name="comment_id")//specify the relation of the foreign key
    @JsonIgnore
    private Comment comment;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="c_id")
//    @JsonIgnore
    private Client client;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="oid")
    @JsonIgnore
    private Set<OrderItem> orderItems;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
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


    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }


}
