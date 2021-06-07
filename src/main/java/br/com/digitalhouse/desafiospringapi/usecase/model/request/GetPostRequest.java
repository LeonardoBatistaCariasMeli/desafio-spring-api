package br.com.digitalhouse.desafiospringapi.usecase.model.request;

import java.io.Serializable;

public class GetPostRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Integer userId;
    private String order;

    public GetPostRequest(Integer userId) {
        this.userId = userId;
    }

    public GetPostRequest(Integer userId, String order) {
        this.userId = userId;
        this.order = order;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getOrder() {
        return order;
    }
}
