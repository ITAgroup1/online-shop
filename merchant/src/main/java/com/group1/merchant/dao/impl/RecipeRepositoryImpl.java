package com.group1.merchant.dao.impl;

import com.group1.core.entity.recipe.Recipe;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import com.group1.merchant.dao.RecipeRepository;
import org.springframework.stereotype.Repository;

@Repository("recipeRepository")
public class RecipeRepositoryImpl extends JPARepositoryImpl<Recipe,String> implements RecipeRepository {
}
