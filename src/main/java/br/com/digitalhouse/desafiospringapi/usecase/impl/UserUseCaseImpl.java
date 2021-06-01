package br.com.digitalhouse.desafiospringapi.usecase.impl;

import br.com.digitalhouse.desafiospringapi.domain.gateways.UserGateway;
import br.com.digitalhouse.desafiospringapi.usecase.UserUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.mapper.UserResponseMapper;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserResponse;
import org.springframework.stereotype.Component;

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
    public UserResponse getQuantityUsersFollowSeller(Integer userId) {
        var user = this.userGateway.getQuantityUsersFollowSeller(userId);
        return UserResponseMapper.fromUser(user);
    }
}
