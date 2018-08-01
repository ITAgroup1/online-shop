package com.group1.core.entity.shop.model;

import com.group1.core.entity.merchant.model.Merchant;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "t_shop")
public class Shop {

    @Id
    @GenericGenerator(name = "ug", strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "service_start_time")
    private Long serviceStartTime;

    @Column(name = "service_end_time")
    private Long serviceEndTime;

    @Column(name = "service_range")
    private Integer serviceRange;

    @Column(name = "distribution_cost")
    private Double distributionCost;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name="customer_shopPic",joinColumns = @JoinColumn(name="shop_id"))
    @Column(name="shopPic")
    @NotNull(message="店内图片不能为空")
    private Set<String> shopPic;

    @Column(name = "business_pic")
    @NotNull(message="工商图片不能为空")
    private String businessPic;

    @Column(name = "address")
    private String address;

    @Column(name = "merchant_id")
    private Merchant merchant;

    @Column(name = "introduction")
    private String introduction;


}
