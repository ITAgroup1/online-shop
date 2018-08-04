package com.group1.merchant.service.impl;

import com.group1.core.entity.recipe.Recipe;
import com.group1.merchant.dao.RecipeRepository;
import com.group1.merchant.service.RecipeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {

    @Resource(name = "recipeRepository")
    private RecipeRepository recipeRepository;

    @Override
    @Transactional
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    @Transactional
    public Recipe getRecipeByShopId(String shopId) {
        return recipeRepository.findOne(shopId);
    }

    @Override
    @Transactional
    public Recipe updateRecipe(Recipe recipe) {
        Recipe recipe1 = recipeRepository.findOne(recipe.getId());
//        recipe1.setId(recipe.getId());
//        recipe1.setPrice(recipe.getPrice());
//        recipe1.setRecipeDetail(recipe.getRecipeDetail());
//        recipe1.setRecipeName(recipe.getRecipeName());
//        recipe1.setRecipePic(recipe.getRecipePic());
        BeanUtils.copyProperties(recipe1,recipe);
        recipeRepository.save(recipe1);
        return recipe1;
    }

    @Override
    @Transactional
    public boolean deleteRecipeById(String recipeId) {
        if(recipeRepository.delete(recipeId).equals(0)) return false;
        return true;
    }
}
