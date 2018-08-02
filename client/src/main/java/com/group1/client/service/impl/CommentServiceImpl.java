package com.group1.client.service.impl;


import com.group1.client.dao.CommentRepository;
import com.group1.client.service.CommentService;
import com.group1.core.entity.comment.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentRepository commentRepository;


    @Override
    public Comment commit(Comment comment) {
        return commentRepository.save(comment);
    }
}
