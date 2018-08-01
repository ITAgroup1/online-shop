package com.group1.client.dao.impl;


import com.group1.client.dao.RecipeRepository;
import com.group1.core.entity.recipe.model.Recipe;
import com.group1.core.utils.base.impl.JPARepositoryImpl;

public class RecipeRepositoryImpl extends JPARepositoryImpl<Recipe,String> implements RecipeRepository {

}
