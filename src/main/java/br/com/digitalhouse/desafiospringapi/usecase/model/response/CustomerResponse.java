package br.com.digitalhouse.desafiospringapi.usecase.model.response;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import java.util.List;

public class CustomerResponse extends UserResponse{

    public CustomerResponse(Integer userId, String name, List<UserResponse> followed) {
        super(userId, name, followed);
    }
}
