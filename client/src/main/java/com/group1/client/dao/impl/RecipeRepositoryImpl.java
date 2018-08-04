package com.group1.client.dao.impl;


import com.group1.client.dao.RecipeRepository;
import com.group1.core.entity.recipe.Recipe;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
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

    @Override
    public Page<Recipe> listByShopId(String shopId, Pageable pageable) {
        Query query = entityManager.createQuery("select r from Recipe r where r.shop.id=:shopId")
                .setFirstResult((pageable.getOffset() - 1) * pageable.getSize())
                .setMaxResults(pageable.getSize());
        query.setParameter("shopId",shopId);
        Query query1 = entityManager.createQuery("select count(1) from Recipe r where r.shop.id=:shopId");
        query1.setParameter("shopId",shopId);
        Integer count = Integer.valueOf(String.valueOf(query1.getSingleResult()));
        List<Recipe> data = query.getResultList();
        Page<Recipe> page = new Page<>();
        page.setData(data); // 分页数据
        page.setOffset(pageable.getOffset()); // 当前页数
        page.setSize(data.size());  //当前页面行数
        page.setTotalSize(count); //总行数
        return page;

    }
}
