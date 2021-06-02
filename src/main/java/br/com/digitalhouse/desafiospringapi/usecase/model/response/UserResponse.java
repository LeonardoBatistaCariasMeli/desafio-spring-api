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
    private TypeUser typeuser;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UserResponse> followed = new ArrayList<>();

    public UserResponse(Integer userId, String name, TypeUser typeuser, List<UserResponse> followed) {
        this.userId = userId;
        this.name = name;
        this.typeuser = typeuser;
        this.followed = followed;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
}
