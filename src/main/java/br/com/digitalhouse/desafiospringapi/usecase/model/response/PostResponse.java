package br.com.digitalhouse.desafiospringapi.usecase.model.response;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PostResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer postId;
    private String date;
    private ProductResponse detail;
    private Integer category;
    private Double price;

    public PostResponse(Integer postId, LocalDate date, ProductResponse detail, Integer category, Double price) {
        this.postId = postId;
        this.detail = detail;
        this.category = category;
        this.price = price;
        convertDate(date);
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
}
