package br.com.digitalhouse.desafiospringapi.usecase.impl;

import br.com.digitalhouse.desafiospringapi.domain.gateways.PostGateway;
import br.com.digitalhouse.desafiospringapi.usecase.PostUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.PostRequest;
import org.springframework.stereotype.Component;

@Component
public class PostUseCaseImpl implements PostUseCase {

    private final PostGateway postGateway;

    public PostUseCaseImpl(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    @Override
    public void registerNewPost(PostRequest request) {
        this.postGateway.registerNewPost(request);
    }

}
