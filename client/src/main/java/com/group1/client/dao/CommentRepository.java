package com.group1.client.dao;

import com.group1.core.entity.comment.Comment;
import com.group1.core.utils.base.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,String> {

}
