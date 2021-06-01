package br.com.digitalhouse.desafiospringapi.usecase.model.request;

public class ProductRequest {

    private Integer productId;

    public ProductRequest() {
    }

    public ProductRequest(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
