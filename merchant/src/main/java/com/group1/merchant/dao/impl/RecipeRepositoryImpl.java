package com.group1.merchant.dao.impl;

import com.group1.core.entity.recipe.Recipe;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import com.group1.merchant.dao.RecipeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("recipeRepository")
public class RecipeRepositoryImpl extends JPARepositoryImpl<Recipe,String> implements RecipeRepository {
    @Override
    public Recipe updateRecipe(Recipe recipe) {
        entityManager.persist(recipe);
        return recipe;
    }

    @Override
    public List<Recipe> findRecipesByShopId(String shopId) {
        String jsql = "select r from Recipe r where r.shop.id=:shopId";
        Query query = entityManager.createQuery(jsql);
        query.setParameter("shopId", shopId);
        List<Recipe> recipes = query.getResultList();
        return recipes;
    }
}
