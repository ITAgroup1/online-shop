package com.group1.merchant.service;

import com.group1.core.entity.recipe.Recipe;

public interface RecipeService {
    Recipe saveRecipe(Recipe recipe);
    Recipe getRecipeByShopId(String shopId);
    Recipe updateRecipe(Recipe recipe);
    Recipe deleteRecipeBysId(String recipeId);
}
