package br.com.digitalhouse.desafiospringapi.usecase.model.response;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class UserResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UserResponse> followed = new ArrayList<>();

    public UserResponse(Integer userId, String name, List<UserResponse> followed) {
        this.userId = userId;
        this.name = name;
        this.followed = followed;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserResponse> getFollowed() {
        return followed;
    }

    public void setFollowed(List<UserResponse> followed) {
        this.followed = followed;
    }
}
