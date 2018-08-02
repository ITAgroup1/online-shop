package com.group1.core.entity.order;


import com.group1.core.entity.recipe.Recipe;
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

}
