package br.com.digitalhouse.desafiospringapi.usecase;

import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserResponse;

public interface UserUseCase {
    public UserResponse getUserById(Integer userId);
    public void followNewSeller(UserRequest request);
    public UserResponse getQuantityUsersFollowSeller(Integer userId);
    public UserResponse getAllUsersFollowSeller(Integer userId);
    public UserResponse getAllSellersThatAnUserFollow(Integer userId);
}
