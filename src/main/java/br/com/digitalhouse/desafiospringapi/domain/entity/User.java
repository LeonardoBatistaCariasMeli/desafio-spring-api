package br.com.digitalhouse.desafiospringapi.domain.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer userId;
    private String name;
    private TypeUser typeuser;
    private List<User> sellers = new ArrayList<>();

    public User(Integer userId, String name, Integer typeuser, List<User> sellers) {
        this.userId = userId;
        this.name = name;
        this.typeuser = TypeUser.toEnum(typeuser);
        this.sellers = sellers;
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

    public List<User> getSellers() {
        return sellers;
    }
}
