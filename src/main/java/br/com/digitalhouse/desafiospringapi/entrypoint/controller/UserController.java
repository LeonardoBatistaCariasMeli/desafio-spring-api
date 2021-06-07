package br.com.digitalhouse.desafiospringapi.entrypoint.controller;

import br.com.digitalhouse.desafiospringapi.usecase.PostUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.UserUseCase;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserPromoPostResponse;
import br.com.digitalhouse.desafiospringapi.usecase.model.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserUseCase userUseCase;
    private final PostUseCase postUseCase;

    public UserController(UserUseCase userUseCase, PostUseCase postUseCase) {
        this.userUseCase = userUseCase;
        this.postUseCase = postUseCase;
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
    public ResponseEntity<UserResponse> getAllUsersFollowSeller(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        UserResponse response = null;
        if (order == null) {
            response = this.userUseCase.getAllUsersFollowSeller(userId);
        } else {
            response = this.userUseCase.getAllUsersFollowSellerOrderBy(userId, order);
        }

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserResponse> getAllSellersThatAnUserFollow(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        UserResponse response = null;
        if (order == null) {
            response =  this.userUseCase.getAllSellersThatAnUserFollow(userId);
        } else {
            response =  this.userUseCase.getAllSellersThatAnUserFollowOrderBy(userId, order);
        }
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollowSeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        var request = new UserRequest(userId, userIdToUnfollow);
        this.userUseCase.unfollowSeller(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/countPromos")
    public ResponseEntity<UserPromoPostResponse> getQuantityOfAllPromoPostsByUserId(@PathVariable Integer userId) {
        var response = this.postUseCase.getQuantityOfAllPromoPostsByUserId(userId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{userId}/promoPosts")
    public ResponseEntity<UserPromoPostResponse> getAllPromoPostsByUserId(@PathVariable Integer userId) {
        var response = this.postUseCase.getAllPromoPostsByUserId(userId);
        return ResponseEntity.ok().body(response);
    }

}
