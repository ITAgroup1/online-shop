package com.group1.client.controller;

import com.group1.client.service.CommentService;
import com.group1.core.entity.comment.Comment;
import com.group1.core.utils.ResultBody;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Resource(name="commentService")
    private CommentService commentService;

    @PostMapping
    @ResponseBody
    public ResultBody commit(@Valid Comment comment,Errors errors){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            resultBody.addData("comment",commentService.commit(comment));
        }else{
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;
    }
}
