package com.group1.client.dao.impl;


import com.group1.client.dao.RecipeRepository;
import com.group1.core.entity.recipe.Recipe;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;


import javax.persistence.Query;
import java.util.List;

@Repository("recipeRepository")
public class RecipeRepositoryImpl extends JPARepositoryImpl<Recipe,String> implements RecipeRepository {

    @Override
    public List<Recipe> listAll(String shopId) {
        Query query = entityManager.createQuery("select r from Recipe r where r.shop.id=:shopId");
        query.setParameter("shopId",shopId);
        List<Recipe> list = query.getResultList();
        return list;
    }
}
