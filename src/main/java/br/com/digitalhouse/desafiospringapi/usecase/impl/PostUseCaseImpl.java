package br.com.digitalhouse.desafiospringapi.usecase.impl;

import br.com.digitalhouse.desafiospringapi.domain.entity.Post;
import br.com.digitalhouse.desafiospringapi.domain.gateways.PostGateway;
import br.com.digitalhouse.desafiospringapi.domain.gateways.UserGateway;
import br.com.digitalhouse.desafiospringapi.usecase.PostUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.mapper.UserPostResponseMapper;
import br.com.digitalhouse.desafiospringapi.usecase.model.mapper.UserPromoPostResponseMapper;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.GetPostRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.PostRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserPostResponse;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserPromoPostResponse;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class PostUseCaseImpl implements PostUseCase {

    private final PostGateway postGateway;
    private final UserGateway userGateway;

    public PostUseCaseImpl(PostGateway postGateway, UserGateway userGateway) {
        this.postGateway = postGateway;
        this.userGateway = userGateway;
    }

    @Override
    public void registerNewPost(PostRequest request) {
        this.postGateway.registerNewPost(request);
    }

    @Override
    public UserPostResponse getAllPostsByUserIdOnLastTwoWeeks(Integer userId) {
        var post = this.postGateway.getAllPostsByUserIdOnLastTwoWeeks(userId);

        return UserPostResponseMapper.toUserPostResponseOf(post);
    }

    @Override
    public UserPostResponse getAllPostsByUserIdOnLastTwoWeeksOrderBy(GetPostRequest request) {
        var posts = this.postGateway.getAllPostsByUserIdOnLastTwoWeeks(request.getPostId());
        this.orderBy(request.getOrder(), posts);
        return UserPostResponseMapper.toUserPostResponseOf(posts);
    }

    private void orderBy(String order, List<Post> posts) {
        if (order.toLowerCase().equals("name_asc")) {
            this.ascending(posts);
        } else if (order.toLowerCase().equals("name_desc")) {
            this.descending(posts);
        }
    }

    private void ascending(List<Post> posts) {
        posts.sort(Comparator.comparing(Post::getDate));
    }

    private void descending(List<Post> posts) {
        posts.sort(Comparator.comparing(Post::getDate).reversed());
    }

    @Override
    public void registerNewPromoPost(PostRequest request) {
        this.postGateway.registerNewPost(request);
    }

    @Override
    public UserPromoPostResponse getQuantityOfAllPromoPostsByUserId(Integer userId) {
        var posts = this.postGateway.getAllPromoPostsByUserId(userId);
        this.addUserInPost(posts.get(0), userId);
        return UserPromoPostResponseMapper.fromListPostForQuantity(posts);
    }

    @Override
    public UserPromoPostResponse getAllPromoPostsByUserId(Integer userId) {
        var posts = this.postGateway.getAllPromoPostsByUserId(userId);
        this.addUserInPost(posts.get(0), userId);
        return UserPromoPostResponseMapper.fromListPost(posts);
    }

    private void addUserInPost(Post post, Integer userId) {
        var user = this.userGateway.getUserById(userId);
        post.setUser(user);
    }
}