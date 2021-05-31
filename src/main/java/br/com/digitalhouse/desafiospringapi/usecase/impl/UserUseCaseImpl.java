package br.com.digitalhouse.desafiospringapi.usecase.impl;

import br.com.digitalhouse.desafiospringapi.domain.gateways.UserGateway;
import br.com.digitalhouse.desafiospringapi.usecase.UserUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserUseCaseImpl implements UserUseCase {

    private final UserGateway userGateway;

    public UserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void followNewSeller(UserRequest request) {
        this.userGateway.followNewSeller(request);
    }
}
