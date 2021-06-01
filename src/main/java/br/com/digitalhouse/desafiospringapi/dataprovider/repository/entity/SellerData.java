package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity;

import javax.persistence.Entity;

@Entity
public class SellerData extends UsersData{

    private Integer typeUser;

    public SellerData() {
    }

    public SellerData(Integer userId, String name, Integer typeUser) {
        super(userId, name);
        this.typeUser = typeUser;
    }

    public Integer getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(Integer typeUser) {
        this.typeUser = typeUser;
    }
}
