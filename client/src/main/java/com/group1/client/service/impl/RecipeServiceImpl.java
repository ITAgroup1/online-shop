package com.group1.client.service.impl;

import com.group1.client.dao.RecipeRepository;
import com.group1.client.service.RecipeService;
import com.group1.core.entity.recipe.Recipe;

import javax.annotation.Resource;
import java.util.List;

public class RecipeServiceImpl implements RecipeService {

    @Resource
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAll(String recipeId) {
        return null;
    }
}
