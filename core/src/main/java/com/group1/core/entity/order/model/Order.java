package com.group1.core.entity.order.model;

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
}
