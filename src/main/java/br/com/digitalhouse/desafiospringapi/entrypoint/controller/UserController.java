package br.com.digitalhouse.desafiospringapi.entrypoint.controller;

import br.com.digitalhouse.desafiospringapi.usecase.UserUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserResponse;
import org.apache.coyote.Response;
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

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer userId) {
        var response = this.userUseCase.getUserById(userId);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followNewSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        var request = new UserRequest(userId, userIdToFollow);

        this.userUseCase.followNewSeller(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getQuantityUsersFollowSeller(@PathVariable Integer userId) {
        var response = this.userUseCase.getQuantityUsersFollowSeller(userId);
        return ResponseEntity.ok().body(response);
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
