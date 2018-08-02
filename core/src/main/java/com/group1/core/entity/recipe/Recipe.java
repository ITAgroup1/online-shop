package com.group1.core.entity.recipe;

import com.group1.core.entity.shop.Shop;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_recipe")
public class Recipe implements Serializable {

    @Id
    @GenericGenerator(name = "ug",strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    @Column(name = "reName")
    private String reName;

    @Column(name = "rePic")
    private String rePic;

    @Column(name = "detail")
    private String detail;

    @Column(name = "price")
    private Integer price;

    @OneToOne(targetEntity=Shop.class)
    @JoinColumn(name="shop_id")
    private Shop shop;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReName() {
        return reName;
    }

    public void setReName(String reName) {
        this.reName = reName;
    }

    public String getRePic() {
        return rePic;
    }

    public void setRePic(String rePic) {
        this.rePic = rePic;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
