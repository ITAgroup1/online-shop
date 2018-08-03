package com.group1.core.entity.merchant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "t_merchant")
public class Merchant {
    @Id
    @GenericGenerator(name = "ug",strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    @Column(name = "login_name")
    @NotBlank(message = "merchant's loginName is null")
    private String loginName;

    @Column
    @NotBlank(message = "merchant's password is null")
    private String password;

    @OneToOne(targetEntity=MerchantDetail.class)
    @JoinColumn(name="detail_id")
    @JsonIgnore
    private MerchantDetail merchantDetail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MerchantDetail getMerchantDetail() {
        return merchantDetail;
    }

    public void setMerchantDetail(MerchantDetail merchantDetail) {
        this.merchantDetail = merchantDetail;
    }
}
