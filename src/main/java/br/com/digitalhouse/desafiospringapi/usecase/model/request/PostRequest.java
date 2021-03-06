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
    private Boolean hasPromo;
    private Double discount;

    public PostRequest(Integer userId, String date, ProductRequest detail, Integer category, Double price, Boolean hasPromo, Double discount) {
        this.userId = userId;
        this.date = this.convertToLocalDate(date);
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    private LocalDate convertToLocalDate(String date) {
        try {
            var dateFormatted = LocalDate.parse(date, DATE_PATTERN);
            if (dateFormatted.isAfter(LocalDate.now()))
                throw new DataIntegrityException("The date needs to be less than today");
            return dateFormatted;
        } catch (Exception e) {
            throw new DataIntegrityException("The date needs the format dd-MM-yyyy and to be less than today");
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

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}