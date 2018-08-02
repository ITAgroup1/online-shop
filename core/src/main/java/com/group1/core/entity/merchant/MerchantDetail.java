package com.group1.core.entity.merchant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "t_merchantDetail")
public class MerchantDetail implements Serializable {

    public final static Integer UNTREATED = 0;//未处理
    public final static Integer PASSED = 1;//同意
    public final static Integer REJECTED = 2;//驳回
    public final static Integer NO_PASSED = 3;//不同意

    @Id
    @GenericGenerator(name = "ug", strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    @OneToOne(mappedBy="merchantDetail",targetEntity=Merchant.class )//数据库的表并不会生成这个字段
    @JsonIgnore
    private Merchant merchant;

    @Column
    @Pattern(regexp="\\d{17}(X|\\d)",message="身份证格式错误")
    private String idcardNum;

    @Column
    @NotNull(message = "身份证照片不能为空")
    private String idcardPic;

    @Column
    @Length(message = "商家名字长度应在1-30位之间", min = 1, max = 30)
    private String merchantName;

//    @OneToOne(targetEntity=Shop.class)
//    @JoinColumn(name="shop_id")
    @Column(name = "shop_id")
    private String shopId;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name="t_shop_pic",joinColumns = @JoinColumn(name="shop_id"))
//    @Column(name="shop_pic")
    @NotNull(message="店内图片不能为空")
    private Set<String> shopPic;

    @Column(name = "business_pic")
    @NotNull(message="工商图片不能为空")
    private String businessPic;

    @Column(name = "status")
    private Integer status;// 狀態：0-待處理、 1-審核通過（拉白）、 2-駁回 3、不同意（拉黑）

    @Length(min = 1, max = 100, message = "店铺地址应在1-100字之间")
    private String address;

    @Length(min = 1, max = 200, message = "店铺介绍应在1-200字之间")
    private String introduction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public String getIdcardNum() {
        return idcardNum;
    }

    public void setIdcardNum(String idcardNum) {
        this.idcardNum = idcardNum;
    }

    public String getIdcardPic() {
        return idcardPic;
    }

    public void setIdcardPic(String idcardPic) {
        this.idcardPic = idcardPic;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "MerchantDetail{" +
                "id='" + id + '\'' +
                ", idcardNum='" + idcardNum + '\'' +
                ", idcardPic='" + idcardPic + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", shopId='" + shopId + '\'' +
                ", shopPic=" + shopPic +
                ", businessPic='" + businessPic + '\'' +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
