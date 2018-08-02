package com.group1.core.entity.recipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group1.core.entity.shop.Shop;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_recipe")
public class Recipe implements Serializable {

    @Id
    @GenericGenerator(name = "ug",strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    @Column(name = "recipe_name")
    private String recipeName;

    @Column(name = "recipe_pic")
    private String recipePic;

    @Column(name = "recipe_detail")
    private String recipeDetail;

    @Column(name = "price")
    private Integer price;

    @ManyToOne(targetEntity = Shop.class,fetch=FetchType.EAGER)
    @JoinColumn(name="shop_id")
    private Shop shop;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipePic() {
        return recipePic;
    }

    public void setRecipePic(String recipePic) {
        this.recipePic = recipePic;
    }

    public String getRecipeDetail() {
        return recipeDetail;
    }

    public void setRecipeDetail(String recipeDetail) {
        this.recipeDetail = recipeDetail;
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
