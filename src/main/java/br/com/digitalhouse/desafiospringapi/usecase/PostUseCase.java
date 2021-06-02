package br.com.digitalhouse.desafiospringapi.usecase;

import br.com.digitalhouse.desafiospringapi.usecase.model.request.PostRequest;

public interface PostUseCase {
    public void registerNewPost(PostRequest request);
}