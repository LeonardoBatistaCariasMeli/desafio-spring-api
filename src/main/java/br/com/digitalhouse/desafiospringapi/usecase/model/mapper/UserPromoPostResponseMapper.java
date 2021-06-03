package br.com.digitalhouse.desafiospringapi.usecase.model.mapper;

import br.com.digitalhouse.desafiospringapi.domain.entity.Post;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserPromoPostResponse;

import java.util.List;

public interface UserPromoPostResponseMapper {

    static UserPromoPostResponse fromListPost(List<Post> posts) {
        var postsResponse = UserPostResponseMapper.fromListPost(posts);
        var user = posts.get(0).getUser();
        return new UserPromoPostResponse(user.getUserId(), user.getName(), postsResponse, null);
    }

    static UserPromoPostResponse fromListPostForQuantity(List<Post> posts) {
        var postsResponse = UserPostResponseMapper.fromListPost(posts);
        var user = posts.get(0).getUser();
        return new UserPromoPostResponse(user.getUserId(), user.getName(), null, posts.size());
    }

}
