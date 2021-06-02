package br.com.digitalhouse.desafiospringapi.usecase.model.response;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeProduct;

public class ProductResponse {

    private Integer productId;
    private String productName;
    private TypeProduct type;
    private String brand;
    private String color;
    private String notes;

    public ProductResponse(Integer productId, String productName, TypeProduct type, String brand, String color, String notes) {
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
