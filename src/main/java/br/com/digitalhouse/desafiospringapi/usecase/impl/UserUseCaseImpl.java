package br.com.digitalhouse.desafiospringapi.usecase.impl;

import br.com.digitalhouse.desafiospringapi.domain.entity.Seller;
import br.com.digitalhouse.desafiospringapi.domain.entity.User;
import br.com.digitalhouse.desafiospringapi.domain.gateways.UserGateway;
import br.com.digitalhouse.desafiospringapi.usecase.UserUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.mapper.UserResponseMapper;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.SellerResponse;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class UserUseCaseImpl implements UserUseCase {

    private final UserGateway userGateway;

    public UserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public UserResponse getUserById(Integer userId) {
        var user = this.userGateway.getUserById(userId);
        return UserResponseMapper.fromUser(user);
    }

    @Override
    public void followNewSeller(UserRequest request) {
        this.userGateway.followNewSeller(request);
    }

    @Override
    public SellerResponse getQuantityUsersFollowSeller(Integer userId) {
        var user = this.userGateway.getUserById(userId);
        return (SellerResponse) UserResponseMapper.fromUserForQuantityUsersFollow(user);
    }

    @Override
    public UserResponse getAllUsersFollowSeller(Integer userId) {
        var user = this.userGateway.getAllUsersFollowSeller(userId);
        return UserResponseMapper.fromUserForAllUsersFollowSeller(user);
    }

    @Override
    public UserResponse getAllSellersThatAnUserFollow(Integer userId) {
        var user = this.userGateway.getUserById(userId);
        return UserResponseMapper.fromUserForAllSellersThatAnUserFollow(user);
    }

    @Override
    public void unfollowSeller(UserRequest request) {
        this.userGateway.unfollowSeller(request);
    }

    @Override
    public UserResponse getAllUsersFollowSellerOrderBy(Integer userId, String order) {
        var user = this.userGateway.getAllUsersFollowSeller(userId);
        this.orderBy(order, user);
        return UserResponseMapper.fromUserForAllUsersFollowSeller(user);
    }

    private void orderBy(String order, User user) {
        var seller = (Seller) user;
        if (order.toLowerCase().equals("name_asc")) {
            this.ascending(seller.getFollowers());
        } else if (order.toLowerCase().equals("name_desc")) {
            this.descending(seller.getFollowers());
        }
    }

    private void ascending(List<User> followers) {
        followers.sort(Comparator.comparing(User::getName));
    }

    private void descending(List<User> followers) {
        followers.sort(Comparator.comparing(User::getName).reversed());
    }

}
