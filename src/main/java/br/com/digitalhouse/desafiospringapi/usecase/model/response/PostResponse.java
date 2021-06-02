package br.com.digitalhouse.desafiospringapi.usecase.model.response;

import java.time.LocalDate;

public class PostResponse {
    private Integer postId;
    private LocalDate date;
    private ProductResponse detail;
    private Integer category;
    private Double price;

    public PostResponse(Integer postId, LocalDate date, ProductResponse detail, Integer category, Double price) {
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
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

    public ProductResponse getDetail() {
        return detail;
    }
}
