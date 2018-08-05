package com.group1.client.service.impl;


import com.group1.client.dao.CommentRepository;
import com.group1.client.service.CommentService;
import com.group1.client.service.ShopService;
import com.group1.core.entity.comment.Comment;
import com.group1.core.entity.shop.Shop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentRepository commentRepository;

    @Resource
    private ShopService shopService;


    @Override
    @Transactional
    public Comment commit(Comment comment) {
        if(comment.getScore()!=null){
            String shopId = comment.getShopId();
            Shop shop = shopService.findOne(shopId);
            Double average = shop.getScore();
            Integer count = commentRepository.count(shopId);
            Double total = average * count;
            Double average1 = (total + comment.getScore())/(count+1);
            shop.setScore(average1);
        }
        return commentRepository.add(comment);

    }

    @Override
    public List<Comment> listAllByShopId(String shopId) {
        return commentRepository.getAllByShopId(shopId);
    }
}
