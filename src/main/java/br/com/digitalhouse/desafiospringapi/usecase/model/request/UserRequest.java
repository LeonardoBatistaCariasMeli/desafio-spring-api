package br.com.digitalhouse.desafiospringapi.usecase.model.request;

import br.com.digitalhouse.desafiospringapi.exceptions.DataIntegrityException;

import java.io.Serializable;

public class UserRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Integer userId;
    private Integer userIdFollow;

    public UserRequest(Integer userId) {
        this.userId = userId;
    }

    public UserRequest(Integer userId, Integer userIdFollow) {
        this.validateIds(userId, userIdFollow);
        this.userId = userId;
        this.userIdFollow = userIdFollow;
    }

    private void validateIds(Integer userId, Integer userIdFollow) {
        if (userId == userIdFollow)
            throw new DataIntegrityException("Both ids owned by same user");
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getUserIdFollow() {
        return userIdFollow;
    }
}
