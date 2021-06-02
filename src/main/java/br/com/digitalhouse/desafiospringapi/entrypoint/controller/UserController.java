package br.com.digitalhouse.desafiospringapi.entrypoint.controller;

import br.com.digitalhouse.desafiospringapi.usecase.UserUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
        var response = this.userUseCase.getAllSellersThatAnUserFollow(userId);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollowSeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        var request = new UserRequest(userId, userIdToUnfollow);
        this.userUseCase.unfollowSeller(request);
        return ResponseEntity.noContent().build();
    }
}
