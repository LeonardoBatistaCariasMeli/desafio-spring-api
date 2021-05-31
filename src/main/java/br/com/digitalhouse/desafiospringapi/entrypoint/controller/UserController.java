package br.com.digitalhouse.desafiospringapi.entrypoint.controller;

import br.com.digitalhouse.desafiospringapi.usecase.UserUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followNewSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        var request = new UserRequest(userId, userIdToFollow);

        this.userUseCase.followNewSeller(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> countAllUsersFollowSellers(@PathVariable Integer userId) {

        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<List<?>> getAllUsersFollowSellers(@PathVariable Integer userId) {

        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<List<?>> getAllSellersThatAnUserFollow(@PathVariable Integer userId) {

        return ResponseEntity.ok().body(null);
    }

}
