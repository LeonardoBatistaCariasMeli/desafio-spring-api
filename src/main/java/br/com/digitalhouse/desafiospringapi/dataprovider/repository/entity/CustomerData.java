package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import javax.persistence.Entity;

@Entity(name = "CUSTOMER")
public class CustomerData extends UserData {

    public CustomerData() {
    }

    public CustomerData(Integer userId, String name, TypeUser typeUser) {
        super(userId, name, typeUser);
    }
}
