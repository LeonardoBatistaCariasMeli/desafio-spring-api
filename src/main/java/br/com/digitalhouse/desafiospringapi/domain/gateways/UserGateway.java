package br.com.digitalhouse.desafiospringapi.domain.gateways;

import br.com.digitalhouse.desafiospringapi.domain.entity.User;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;

public interface UserGateway {
    public User getUserById(Integer userId);
    public void followNewSeller(UserRequest request);
    public User getAllUsersFollowSeller(Integer userId);
}
