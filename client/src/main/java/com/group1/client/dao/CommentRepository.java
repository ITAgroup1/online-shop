package com.group1.client.dao;

import com.group1.core.entity.comment.Comment;
import com.group1.core.utils.base.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,String> {
    List<Comment> getAllByShopId(String shopId);

}
