package br.com.digitalhouse.desafiospringapi.domain.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer userId;
    private String name;
    private TypeUser typeUser;
    private List<User> followed = new ArrayList<>();
    private List<User> followers = new ArrayList<>();
    private Integer quantityFollowers;

    public User(Integer userId, String name, Integer typeUser, List<User> followed, List<User> followers, Integer quantityFollowers) {
        this.userId = userId;
        this.name = name;
        this.typeUser = TypeUser.toEnum(typeUser);
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

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public List<User> getFollowed() {
        return followed;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public Integer getQuantityFollowers() {
        return quantityFollowers;
    }
}
