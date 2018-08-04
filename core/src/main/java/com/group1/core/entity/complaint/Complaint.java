package com.group1.core.entity.complaint;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_complaint")
public class Complaint implements Serializable {

    public final static Integer UNTREATED = 0;//未处理
    public final static Integer DEALING = 1;//处理中
    public final static Integer FINISHED = 2;//完成
    public final static Integer IGNOGE = 3;//忽略

    @Id
    @GenericGenerator(name = "ug",strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    @Column(name = "content")
    private String content;

    @Column(name = "shop_id")
    private String shopId;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "status")
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", shopId='" + shopId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", status=" + status +
                '}';
    }
}
