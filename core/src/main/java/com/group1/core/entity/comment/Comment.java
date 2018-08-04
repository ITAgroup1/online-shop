package com.group1.core.entity.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.group1.core.entity.order.Order;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_comment")
public class Comment implements Serializable {

    @Id
    @GenericGenerator(name = "ug", strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    @Column(name = "score")
    private Integer score;

    @Column(name = "content")
    private String content;

    @Column(name = "comment_time")
    private String commentTime;

    @Column(name = "shop_id")
    private String shopId;


//        one to one
    @OneToOne(mappedBy = "comment", targetEntity = Order.class)
    @JsonIgnore
    private Order order;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
