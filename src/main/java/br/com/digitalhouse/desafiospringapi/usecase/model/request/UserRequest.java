package br.com.digitalhouse.desafiospringapi.usecase.model.request;

public class UserRequest {

    private final Integer userId;
    private Integer userIdSeller;

    public UserRequest(Integer userId) {
        this.userId = userId;
    }

    public UserRequest(Integer userId, Integer userIdSeller) {
        this.userId = userId;
        this.userIdSeller = userIdSeller;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getUserIdSeller() {
        return userIdSeller;
    }
}
