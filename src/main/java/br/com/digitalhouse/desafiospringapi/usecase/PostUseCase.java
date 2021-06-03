package br.com.digitalhouse.desafiospringapi.usecase;

import br.com.digitalhouse.desafiospringapi.usecase.model.request.GetPostRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.PostRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserPostResponse;

public interface PostUseCase {
    public void registerNewPost(PostRequest request);

    public UserPostResponse getAllPostsByUserIdOnLastTwoWeeks(Integer userId);

    public UserPostResponse getAllPostsByUserIdOnLastTwoWeeksOrderBy(GetPostRequest request);

    public void registerNewPromoPost(PostRequest request);
}