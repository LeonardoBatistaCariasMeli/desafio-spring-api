package br.com.digitalhouse.desafiospringapi.usecase;

import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.SellerResponse;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserResponse;

public interface UserUseCase {
    public UserResponse getUserById(Integer userId);

    public void followNewSeller(UserRequest request);

    public SellerResponse getQuantityUsersFollowSeller(Integer userId);

    public UserResponse getAllUsersFollowSeller(Integer userId);

    public UserResponse getAllSellersThatAnUserFollow(Integer userId);

    public void unfollowSeller(UserRequest request);

    public UserResponse getAllUsersFollowSellerOrderBy(Integer userId, String order);

    public UserResponse getAllSellersThatAnUserFollowOrderBy(Integer userId, String order);
}
