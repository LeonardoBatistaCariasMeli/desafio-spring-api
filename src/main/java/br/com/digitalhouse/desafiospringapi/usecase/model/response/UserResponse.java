package br.com.digitalhouse.desafiospringapi.usecase.model.response;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String name;
    private TypeUser typeuser;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UserResponse> followed = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UserResponse> followers = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer quantityFollowers;

    public UserResponse(Integer userId, String name, TypeUser typeuser, List<UserResponse> followed, List<UserResponse> followers, Integer quantityFollowers) {
        this.userId = userId;
        this.name = name;
        this.typeuser = typeuser;
        this.followed = followed;
        this.followers = followers;
        this.quantityFollowers = quantityFollowers;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public TypeUser getTypeuser() {
        return typeuser;
    }

    public List<UserResponse> getFollowed() {
        return followed;
    }

    public List<UserResponse> getFollowers() {
        return followers;
    }

    public Integer getQuantityFollowers() {
        return quantityFollowers;
    }
}
