package com.group1.core.entity.merchant.model;

import com.group1.core.entity.shop.model.Shop;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


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
    private Merchant merchant;

    @Pattern(regexp="\\d{17}(X|\\d)",message="身份证格式错误")
    private String idcardNum;

    @NotNull(message = "身份证照片不能为空")
    private String idcardPic;

    @Length(message = "商家名字长度应在1-30位之间", min = 1, max = 30)
    private String merchantName;

//    @OneToOne(targetEntity=Shop.class)
//    @JoinColumn(name="shop_id")
    @Column(name = "shopId")
    private String shopId;

    @Column(name = "score")
    private Double score;

    @Column(name = "status")
    private Integer status;// 狀態：0-待處理、 1-審核通過（拉白）、 2-駁回 3、不同意（拉黑）

    @Length(min = 1, max = 100, message = "店铺地址应在1-100字之间")
    private String address;

    @Length(min = 1, max = 200, message = "店铺介绍应在1-200字之间")
    private String introduction;


}
