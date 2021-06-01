package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class ProductData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private Integer type;
    private String brand;
    private String color;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    public ProductData() {
    }

    public ProductData(Integer productId, String productName, Integer type, String brand, String color, String notes) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}