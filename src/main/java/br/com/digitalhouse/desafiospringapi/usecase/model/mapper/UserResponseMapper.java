package br.com.digitalhouse.desafiospringapi.usecase.model.mapper;

import br.com.digitalhouse.desafiospringapi.domain.entity.User;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface UserResponseMapper {

    static UserResponse fromUser(User user) {
        var following = assemblesFollowingOrFollowersListOf(user.getFollowed());
        var followers = assemblesFollowingOrFollowersListOf(user.getFollowers());
        var quantityFollowers = user.getQuantityFollowers() == 0 ? null : user.getQuantityFollowers();
        return new UserResponse(user.getUserId(), user.getName(), user.getTypeUser(), following, followers, quantityFollowers);
    }

    static List<UserResponse> assemblesFollowingOrFollowersListOf(List<User> listData) {
        if(listData.isEmpty()) {
            return new ArrayList<>();
        }
        return listData.stream().map(UserResponseMapper::assembleFollowingOrFollowersOf).collect(Collectors.toList());
    }

    static UserResponse assembleFollowingOrFollowersOf(User user) {
        var following = new ArrayList<UserResponse>();
        var followers = new ArrayList<UserResponse>();
        var quantityFollowers = user.getQuantityFollowers() == 0 ? null : user.getQuantityFollowers();
        return new UserResponse(user.getUserId(), user.getName(), user.getTypeUser(), following, followers, quantityFollowers);
    }
}
