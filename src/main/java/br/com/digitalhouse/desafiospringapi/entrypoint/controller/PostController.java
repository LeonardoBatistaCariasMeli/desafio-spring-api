package br.com.digitalhouse.desafiospringapi.entrypoint.controller;

import br.com.digitalhouse.desafiospringapi.usecase.PostUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.PostRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserPostResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class PostController {

    private final PostUseCase postUseCase;

    public PostController(PostUseCase postUseCase) {
        this.postUseCase = postUseCase;
    }

    @PostMapping("/posts")
    public ResponseEntity<Void> registerNewPost(@RequestBody PostRequest request) {
        this.postUseCase.registerNewPost(request);
        return ResponseEntity.created(URI.create("")).build();
    }

    @GetMapping("/followed/{userId}/posts")
    public ResponseEntity<UserPostResponse> getAllPostsByUserIdOnLastTwoWeeks(@PathVariable Integer userId) {
        var response = this.postUseCase.getAllPostsByUserIdOnLastTwoWeeks(userId);
        return ResponseEntity.ok().body(response);
    }

}