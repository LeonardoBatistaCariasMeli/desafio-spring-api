package br.com.digitalhouse.desafiospringapi.usecase.model.response;

import java.util.ArrayList;
import java.util.List;

public class UserPostResponse {

    private Integer userId;
    private List<PostResponse> posts = new ArrayList<>();

    public UserPostResponse(Integer userId, List<PostResponse> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public Integer getUserId() {
        return userId;
    }

    public List<PostResponse> getPosts() {
        return posts;
    }
}
