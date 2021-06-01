package br.com.digitalhouse.desafiospringapi.usecase.model.mapper;

import br.com.digitalhouse.desafiospringapi.domain.entity.User;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface UserResponseMapper {

    static UserResponse fromUser(User user) {
        var sellers = assemblesSellersListOf(user.getSellers());
        var quantityFollowers = user.getQuantityFollowers() == 0 ? null : user.getQuantityFollowers();
        return new UserResponse(user.getUserId(), user.getName(), user.getTypeUser(), sellers, quantityFollowers);
    }

    static List<UserResponse> assemblesSellersListOf(List<User> listData) {
        return listData.stream().map(UserResponseMapper::assembleSellerOf).collect(Collectors.toList());
    }

    static UserResponse assembleSellerOf(User user) {
        var quantityFollowers = user.getQuantityFollowers() == 0 ? null : user.getQuantityFollowers();
        return new UserResponse(user.getUserId(), user.getName(), user.getTypeUser(), new ArrayList<>(), quantityFollowers);
    }

}
