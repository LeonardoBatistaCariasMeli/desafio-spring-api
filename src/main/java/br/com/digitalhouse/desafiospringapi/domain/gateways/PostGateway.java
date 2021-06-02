package br.com.digitalhouse.desafiospringapi.domain.gateways;

import br.com.digitalhouse.desafiospringapi.usecase.model.request.PostRequest;

public interface PostGateway {
    public void registerNewPost(PostRequest request);
}