package br.com.digitalhouse.desafiospringapi.entrypoint.controller;

import br.com.digitalhouse.desafiospringapi.usecase.UserUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserResponse> getQuantityUsersFollowSeller(@PathVariable Integer userId) {
        var response = this.userUseCase.getQuantityUsersFollowSeller(userId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserResponse> getAllUsersFollowSeller(@PathVariable Integer userId) {
        var response = this.userUseCase.getAllUsersFollowSeller(userId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserResponse> getAllSellersThatAnUserFollow(@PathVariable Integer userId) {

        return ResponseEntity.ok().body(null);
    }

}
