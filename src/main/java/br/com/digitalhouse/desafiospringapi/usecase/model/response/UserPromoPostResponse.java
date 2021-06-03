package br.com.digitalhouse.desafiospringapi.usecase.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class UserPromoPostResponse {

    private Integer userId;
    private String username;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<PostResponse> posts;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer promoproductsCount;

    public UserPromoPostResponse(Integer userId, String username, List<PostResponse> posts, Integer promoproductsCount) {
        this.userId = userId;
        this.username = username;
        this.posts = posts;
        this.promoproductsCount = promoproductsCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public List<PostResponse> getPosts() {
        return posts;
    }

    public Integer getPromoproductsCount() {
        return promoproductsCount;
    }
}
