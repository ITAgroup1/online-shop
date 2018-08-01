package com.group1.core.entity.merchant.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

public class Merchant {
    @Id
    @GenericGenerator(name = "ug",strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    private String loginName;

    private String password;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id")
    private MerchantDetail merchantDetail;

}
