package com.group1.client.dao.impl;

import com.group1.client.dao.CommentRepository;
import com.group1.core.entity.comment.Comment;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resources;
import javax.persistence.Query;
import java.util.List;

@Repository("commentRepository")
public class CommentRepositoryImpl extends JPARepositoryImpl<Comment,String> implements CommentRepository {

    @Override
    public List<Comment> getAllByShopId(String shopId) {
        Query query = entityManager.createQuery("select c from Comment c where c.shopId=:shopId");
        query.setParameter("shopId",shopId);
        List<Comment> list = query.getResultList();
        return list;
    }

    @Override
    public Integer count(String shopId) {
        Query query = entityManager.createQuery("select count(1) from Comment c where c.score is not null");
        Integer count = Integer.valueOf(String.valueOf(query.getSingleResult()));
        return count;
    }
}
