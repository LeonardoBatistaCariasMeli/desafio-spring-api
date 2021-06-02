package br.com.digitalhouse.desafiospringapi.usecase.model.request;

import br.com.digitalhouse.desafiospringapi.exceptions.DataIntegrityException;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PostRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private Integer userId;
    private LocalDate date;
    private ProductRequest detail;
    private Integer category;
    private Double price;

    public PostRequest(Integer userId, String date, ProductRequest detail, Integer category, Double price) {
        this.userId = userId;
        this.date = this.convertToLocalDate(date);
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    private LocalDate convertToLocalDate(String date) {
        try {
            return LocalDate.parse(date, DATE_PATTERN);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("The date need the format dd-MM-yyyy");
        }

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ProductRequest getDetail() {
        return detail;
    }

    public void setDetail(ProductRequest detail) {
        this.detail = detail;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}