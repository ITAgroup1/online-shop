package com.group1.merchant.service;

import com.group1.core.entity.recipe.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe saveRecipe(Recipe recipe);
    List<Recipe> getRecipesByShopId(String shopId);
    Recipe updateRecipe(Recipe recipe);
    boolean deleteRecipeById(String recipeId);
}
