package br.com.digitalhouse.desafiospringapi.domain.entity;

import java.time.LocalDate;

public class Post {

    private Integer postId;
    private LocalDate date;
    private Integer category;
    private Double price;
    private Product detail;
    private User user;

    public Post(Integer postId, LocalDate date, Integer category, Double price, Product detail, User user) {
        this.postId = postId;
        this.date = date;
        this.category = category;
        this.price = price;
        this.detail = detail;
        this.user = user;
    }

    public Integer getPostId() {
        return postId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public Product getDetail() {
        return detail;
    }

    public User getUser() {
        return user;
    }
}
