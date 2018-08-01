package com.group1.core.entity.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group1.core.entity.order.Order;
import com.group1.core.entity.order.OrderItem;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "t_client")
public class Client implements Serializable {
    @Id
    @GenericGenerator(name = "ug",strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    @Column(name = "loginName",nullable = false,length = 255)
    @NotBlank(message = "client's loginName is null")
    private String loginName;

    @Column(name = "password",nullable = false,length = 255)
    @NotBlank(message = "client's password is null")
    private String password;

    private String address;

    private String phone;

    @OneToMany(targetEntity=OrderItem.class,cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="clientId")
    @JsonIgnore
    private Set<Order> orders;
}
