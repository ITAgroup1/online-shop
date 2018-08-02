package com.group1.client.service;

import com.group1.core.entity.recipe.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll(String recipeId);
}
