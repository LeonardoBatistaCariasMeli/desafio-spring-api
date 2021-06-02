package br.com.digitalhouse.desafiospringapi.usecase.model.request;

import br.com.digitalhouse.desafiospringapi.exceptions.DataIntegrityException;

import java.io.Serializable;

public class UserRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Integer userId;
    private Integer sellerId;

    public UserRequest(Integer userId) {
        this.userId = userId;
    }

    public UserRequest(Integer userId, Integer sellerId) {
        this.validateIds(userId, sellerId);
        this.userId = userId;
        this.sellerId = sellerId;
    }

    private void validateIds(Integer userId, Integer sellerId) {
        if (userId == sellerId)
            throw new DataIntegrityException("Both ids owned by same user");
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getSellerId() {
        return sellerId;
    }
}
