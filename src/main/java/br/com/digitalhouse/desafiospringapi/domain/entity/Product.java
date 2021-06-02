package br.com.digitalhouse.desafiospringapi.domain.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeProduct;

public class Product {

    private Integer productId;
    private String productName;
    private TypeProduct type;
    private String brand;
    private String color;
    private String notes;

    public Product(Integer productId, String productName, Integer type, String brand, String color, String notes) {
        this.productId = productId;
        this.productName = productName;
        this.type = TypeProduct.toEnum(type);
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public TypeProduct getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getNotes() {
        return notes;
    }
}
