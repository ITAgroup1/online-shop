package com.group1.core.entity.order;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group1.core.entity.recipe.Recipe;
import org.aspectj.weaver.ast.Or;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_orderItem")
public class OrderItem {

    @Id
    @GenericGenerator(name = "ug",strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

//    @OneToOne(targetEntity=Recipe.class)
//    @JoinColumn(name="recipe_id")
    @Column(name = "recipe_id")
    private String recipeId;

    @Column(name = "recipe_Name")
    private String recipeName;

    @Column(name = "price")
    private String price;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="oid")
    @JsonIgnore
    private Order order;

    @Column
    private Integer count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
