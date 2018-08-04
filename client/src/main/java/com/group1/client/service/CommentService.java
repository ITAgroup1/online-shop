package com.group1.client.service;

import com.group1.core.entity.comment.Comment;

import java.util.List;

public interface CommentService {
    Comment commit(Comment comment);
    List<Comment> listAllByShopId(String shopId);
}
