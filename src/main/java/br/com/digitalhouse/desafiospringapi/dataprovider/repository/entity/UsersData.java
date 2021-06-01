package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity;

import javax.persistence.*;

@Inheritance
@Entity
@Table(name = "USERS")
public abstract class UsersData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;

    public UsersData() {
    }

    public UsersData(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
