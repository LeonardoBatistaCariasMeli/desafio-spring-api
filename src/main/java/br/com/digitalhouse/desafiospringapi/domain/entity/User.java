package br.com.digitalhouse.desafiospringapi.domain.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer userId;
    private String name;
    private TypeUser typeUser;
    private List<User> sellers = new ArrayList<>();
    private Integer quantityFollowers;

    public User(Integer userId, String name, Integer typeUser, List<User> sellers, Integer quantityFollowers) {
        this.userId = userId;
        this.name = name;
        this.typeUser = TypeUser.toEnum(typeUser);
        this.sellers = sellers;
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

    public List<User> getSellers() {
        return sellers;
    }

    public Integer getQuantityFollowers() {
        return quantityFollowers;
    }
}
