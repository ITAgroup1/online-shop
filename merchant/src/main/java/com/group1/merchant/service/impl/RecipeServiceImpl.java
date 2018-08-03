package com.group1.merchant.service.impl;

import com.group1.core.entity.recipe.Recipe;
import com.group1.merchant.service.RecipeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {
    @Override
    @Transactional
    public Recipe saveRecipe(Recipe recipe) {
        return null;
    }

    @Override
    @Transactional
    public Recipe getRecipeByShopId(String shopId) {
        return null;
    }

    @Override
    @Transactional
    public Recipe updateRecipe(Recipe recipe) {
        return null;
    }

    @Override
    @Transactional
    public Recipe deleteRecipeBysId(String recipeId) {
        return null;
    }
}
