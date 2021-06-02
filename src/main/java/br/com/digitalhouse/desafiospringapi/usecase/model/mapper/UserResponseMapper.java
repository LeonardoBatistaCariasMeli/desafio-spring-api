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
        var followed = assemblesFollowingOrFollowersListOf(user.getFollowed());

        if(user.getClass().getSimpleName().equals("Seller")) {
            var seller = (Seller) user;
            var quantityFollowers = seller.getFollowers() == null ? null : seller.getFollowers().size();
            var followers = assemblesFollowingOrFollowersListOf(seller.getFollowers());
            return new SellerResponse(seller.getUserId(), seller.getName(), seller.getTypeUser(), followed, followers, quantityFollowers);
        }

        return new CustomerResponse(user.getUserId(), user.getName(), user.getTypeUser(), followed);
    }

    static List<UserResponse> assemblesFollowingOrFollowersListOf(List<User> list) {
        if(list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        return list.stream().map(UserResponseMapper::assembleFollowingOrFollowersOf).collect(Collectors.toList());
    }

    static UserResponse assembleFollowingOrFollowersOf(User user) {
        if(user.getClass().getSimpleName().equals("Customer")) {
            return new CustomerResponse(user.getUserId(), user.getName(), user.getTypeUser(), null);
        } else {
            return new SellerResponse(user.getUserId(), user.getName(), user.getTypeUser(), null, null, null);
        }
    }
}
