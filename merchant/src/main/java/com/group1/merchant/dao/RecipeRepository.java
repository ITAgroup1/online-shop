package com.group1.merchant.dao;

import com.group1.core.entity.recipe.Recipe;
import com.group1.core.utils.base.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,String> {
    Recipe updateRecipe(Recipe recipe);
    List<Recipe> findRecipesByShopId(String shopId);
}
