package br.com.digitalhouse.desafiospringapi.usecase.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PostResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer postId;
    private String date;
    private ProductResponse detail;
    private Integer category;
    private Double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean hasPromo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double discount;

    public PostResponse(Integer postId, LocalDate date, ProductResponse detail, Integer category, Double price, Boolean hasPromo, Double discount) {
        this.postId = postId;
        convertDate(date);
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    private void convertDate(LocalDate localDate) {
        var pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var date = localDate.format(pattern);
        this.date = date;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getDate() {
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

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }
}
