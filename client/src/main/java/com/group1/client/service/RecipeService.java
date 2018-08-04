package com.group1.client.service;

import com.group1.core.entity.recipe.Recipe;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll(String shopId);
    Page<Recipe> getAllByShopId(String shopId, Pageable pageable);
}
