package com.group1.client.dao.impl;

import com.group1.client.dao.CommentRepository;
import com.group1.core.entity.comment.Comment;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resources;

@Repository("commentRepository")
public class CommentRepositoryImpl extends JPARepositoryImpl<Comment,String> implements CommentRepository {

}
