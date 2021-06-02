package br.com.digitalhouse.desafiospringapi.domain.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import java.util.ArrayList;
import java.util.List;

public abstract class User {

    private Integer userId;
    private String name;
    private TypeUser typeUser;
    private List<User> followed = new ArrayList<>();

    public User(Integer userId, String name, Integer typeUser, List<User> followed) {
        this.userId = userId;
        this.name = name;
        this.typeUser = TypeUser.toEnum(typeUser);
        this.followed = followed;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public List<User> getFollowed() {
        return followed;
    }
}
