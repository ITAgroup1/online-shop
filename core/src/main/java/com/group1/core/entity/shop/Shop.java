package com.group1.core.entity.shop;

import com.group1.core.entity.merchant.MerchantDetail;
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

    @Column(name = "merchantDetail")
    private MerchantDetail merchantDetail;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "score")
    private Double score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(Long serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public Long getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(Long serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    public Integer getServiceRange() {
        return serviceRange;
    }

    public void setServiceRange(Integer serviceRange) {
        this.serviceRange = serviceRange;
    }

    public Double getDistributionCost() {
        return distributionCost;
    }

    public void setDistributionCost(Double distributionCost) {
        this.distributionCost = distributionCost;
    }

    public Set<String> getShopPic() {
        return shopPic;
    }

    public void setShopPic(Set<String> shopPic) {
        this.shopPic = shopPic;
    }

    public String getBusinessPic() {
        return businessPic;
    }

    public void setBusinessPic(String businessPic) {
        this.businessPic = businessPic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MerchantDetail getMerchantDetail() {
        return merchantDetail;
    }

    public void setMerchantDetail(MerchantDetail merchantDetail) {
        this.merchantDetail = merchantDetail;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
