package br.com.digitalhouse.desafiospringapi.usecase.model.request;

import br.com.digitalhouse.desafiospringapi.exceptions.DataIntegrityException;

import java.io.Serializable;

public class UserRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Integer userId;
    private Integer userIdSeller;

    public UserRequest(Integer userId) {
        this.userId = userId;
    }

    public UserRequest(Integer userId, Integer userIdSeller) {
        validateIds(userId, userIdSeller);
        this.userId = userId;
        this.userIdSeller = userIdSeller;
    }

    public void validateIds(Integer userId, Integer userIdSeller) {
        if (userId == userIdSeller)
            throw new DataIntegrityException("Both ids owned by same user");
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getUserIdSeller() {
        return userIdSeller;
    }
}
