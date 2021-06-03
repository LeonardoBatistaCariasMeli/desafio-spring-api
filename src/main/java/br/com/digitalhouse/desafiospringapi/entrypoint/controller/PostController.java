package br.com.digitalhouse.desafiospringapi.entrypoint.controller;

import br.com.digitalhouse.desafiospringapi.usecase.PostUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.GetPostRequest;
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
    public ResponseEntity<UserPostResponse> getAllPostsByUserIdOnLastTwoWeeks(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        UserPostResponse response = null;
        if(order == null) {
            response = this.postUseCase.getAllPostsByUserIdOnLastTwoWeeks(userId);
        } else {
            var request = new GetPostRequest(userId, order);
            response = this.postUseCase.getAllPostsByUserIdOnLastTwoWeeksOrderBy(request);
        }
        return ResponseEntity.ok().body(response);
    }

}