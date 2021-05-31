package br.com.digitalhouse.desafiospringapi.usecase;

import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;

public interface UserUseCase {
    public void followNewSeller(UserRequest request);
}
