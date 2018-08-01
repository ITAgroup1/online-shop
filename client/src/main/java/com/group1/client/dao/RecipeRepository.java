package com.group1.client.dao;

import com.group1.core.entity.recipe.model.Recipe;
import com.group1.core.utils.base.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,String> {
}
