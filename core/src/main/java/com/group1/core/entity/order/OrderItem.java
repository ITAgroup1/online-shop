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

    @OneToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


    private Integer count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
