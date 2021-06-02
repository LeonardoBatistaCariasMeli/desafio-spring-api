package br.com.digitalhouse.desafiospringapi.domain.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {

    private List<User> followers = new ArrayList<>();

    public Seller(Integer userId, String name, Integer typeUser, List<User> followed, List<User> followers) {
        super(userId, name, typeUser, followed);
        this.followers = followers;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
}
