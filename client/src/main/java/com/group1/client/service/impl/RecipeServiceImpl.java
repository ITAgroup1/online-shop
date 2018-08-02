package com.group1.client.service.impl;

import com.group1.client.dao.RecipeRepository;
import com.group1.client.service.RecipeService;
import com.group1.core.entity.recipe.Recipe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Resource(name="recipeRepository")
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAll(String shopId) {
        return recipeRepository.listAll(shopId);
    }
}
