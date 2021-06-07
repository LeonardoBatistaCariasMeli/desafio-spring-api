package br.com.digitalhouse.desafiospringapi.usecase;

import br.com.digitalhouse.desafiospringapi.usecase.model.request.GetPostRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.PostRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserPostResponse;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserPromoPostResponse;

public interface PostUseCase {
    public void registerNewPost(PostRequest request);

    public UserPostResponse getAllPostsOfSellersFollowedByUserIdOnLastTwoWeeks(Integer userId);

    public UserPostResponse getAllPostsOfSellersFollowedByUserIdOnLastTwoWeeksOrderBy(GetPostRequest request);

    public void registerNewPromoPost(PostRequest request);

    public UserPromoPostResponse getQuantityOfAllPromoPostsByUserId(Integer userId);

    public UserPromoPostResponse getAllPromoPostsByUserId(Integer userId);
}