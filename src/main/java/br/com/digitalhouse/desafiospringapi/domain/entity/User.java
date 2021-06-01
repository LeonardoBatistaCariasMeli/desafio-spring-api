package br.com.digitalhouse.desafiospringapi.domain.entity;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer userId;
    private String name;
    private TypeUser typeUser;
    private List<User> following = new ArrayList<>();
    private List<User> followers = new ArrayList<>();
    private Integer quantityFollowers;

    public User(Integer userId, String name, Integer typeUser, List<User> following, List<User> followers, Integer quantityFollowers) {
        this.userId = userId;
        this.name = name;
        this.typeUser = TypeUser.toEnum(typeUser);
        this.following = following;
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

    public List<User> getFollowing() {
        return following;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public Integer getQuantityFollowers() {
        return quantityFollowers;
    }
}
