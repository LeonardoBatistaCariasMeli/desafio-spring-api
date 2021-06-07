package br.com.digitalhouse.desafiospringapi.usecase.model.mapper;

import br.com.digitalhouse.desafiospringapi.domain.entity.Post;
import br.com.digitalhouse.desafiospringapi.domain.entity.Product;
import br.com.digitalhouse.desafiospringapi.domain.entity.User;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.PostResponse;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.ProductResponse;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserPostResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface UserPostResponseMapper {

    static UserPostResponse toUserPostResponseOf(Integer userId, List<Post> posts) {
        var postsResponse = fromListPost(posts);

        return new UserPostResponse(userId, postsResponse);
    }

    static List<PostResponse> fromListPost(List<Post> posts) {
        if (posts.isEmpty()) {
            return new ArrayList<>();
        }

        return posts.stream().map(UserPostResponseMapper::fromPost).collect(Collectors.toList());
    }

    static PostResponse fromPost(Post post) {
        var product = fromProduct(post.getDetail());
        var hasPromo = post.getHasPromo() ? true : null;
        return new PostResponse(post.getPostId(), post.getDate(), product, post.getCategory(), post.getPrice(), hasPromo, post.getDiscount());
    }

    static ProductResponse fromProduct(Product product) {
        return new ProductResponse(product.getProductId(), product.getProductName(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }

}
