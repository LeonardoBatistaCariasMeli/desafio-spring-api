package br.com.digitalhouse.desafiospringapi.usecase.model.request;

import java.io.Serializable;

public class GetPostRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Integer postId;
    private String order;

    public GetPostRequest(Integer postId) {
        this.postId = postId;
    }

    public GetPostRequest(Integer postId, String order) {
        this.postId = postId;
        this.order = order;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getOrder() {
        return order;
    }
}
