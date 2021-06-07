package br.com.digitalhouse.desafiospringapi.domain.gateways;

import br.com.digitalhouse.desafiospringapi.domain.entity.Post;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.PostRequest;

import java.util.List;

public interface PostGateway {
    public void registerNewPost(PostRequest request);

    public List<Post> getAllPostsOfSellersFollowedByUserIdOnLastTwoWeeks(Integer userId);

    public List<Post> getAllPromoPostsByUserId(Integer userId);
}