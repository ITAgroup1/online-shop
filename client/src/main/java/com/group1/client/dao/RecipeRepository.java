package com.group1.client.dao;

import com.group1.core.entity.recipe.Recipe;
import com.group1.core.utils.base.JpaRepository;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,String> {
    List<Recipe> listAll(String shopId);
    Page<Recipe> listByShopId(String shopId, Pageable pageable);
}
