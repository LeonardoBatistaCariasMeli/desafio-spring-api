package br.com.digitalhouse.desafiospringapi.usecase.model.mapper;

import br.com.digitalhouse.desafiospringapi.domain.entity.Seller;
import br.com.digitalhouse.desafiospringapi.domain.entity.User;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.CustomerResponse;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.SellerResponse;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface UserResponseMapper {

    static UserResponse fromUser(User user) {
        var followed = assemblesFollowedOrFollowersListOf(user.getFollowed());

        if (user.getClass().getSimpleName().equals("Seller")) {
            var seller = (Seller) user;
            var followers = assemblesFollowedOrFollowersListOf(seller.getFollowers());
            return new SellerResponse(seller.getUserId(), seller.getName(), followed, followers, null);
        }

        return new CustomerResponse(user.getUserId(), user.getName(), followed);
    }

    static List<UserResponse> assemblesFollowedOrFollowersListOf(List<User> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        return list.stream().map(UserResponseMapper::assembleFollowedOrFollowersOf).collect(Collectors.toList());
    }

    static UserResponse assembleFollowedOrFollowersOf(User user) {
        if (user.getClass().getSimpleName().equals("Customer")) {
            return new CustomerResponse(user.getUserId(), user.getName(), null);
        }
        return new SellerResponse(user.getUserId(), user.getName(), null, null, null);
    }

    static UserResponse fromUserForQuantityUsersFollow(User user) {
        var seller = (Seller) user;
        var followers = assemblesFollowedOrFollowersListOf(seller.getFollowers());

        return new SellerResponse(seller.getUserId(), seller.getName(), null, null, followers.size());
    }

    static UserResponse fromUserForAllUsersFollowSeller(User user) {
        var seller = (Seller) user;
        var followers = assemblesFollowedOrFollowersListOf(seller.getFollowers());

        return new SellerResponse(seller.getUserId(), seller.getName(), null, followers, null);
    }

    static UserResponse fromUserForAllSellersThatAnUserFollow(User user) {
        var followed = assemblesFollowedOrFollowersListOf(user.getFollowed());

        if (user.getClass().getSimpleName().equals("Seller")) {
            return new SellerResponse(user.getUserId(), user.getName(), followed, null, null);
        }

        return new CustomerResponse(user.getUserId(), user.getName(), followed);
    }

}
