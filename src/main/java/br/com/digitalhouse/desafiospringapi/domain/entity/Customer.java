package br.com.digitalhouse.desafiospringapi.domain.entity;

import java.util.List;

public class Customer extends User{

    public Customer(Integer userId, String name, Integer typeUser, List<User> followed) {
        super(userId, name, typeUser, followed);
    }
}
