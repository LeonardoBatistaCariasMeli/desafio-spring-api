package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private Integer typeUser;

    @ManyToMany
    @JoinTable(name = "SELLER",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "sellerId")
    )
    private List<UserData> sellers = new ArrayList<>();

    public UserData() {
    }

    public UserData(Integer userId, String name, TypeUser typeUser, List<UserData> sellers) {
        this.userId = userId;
        this.name = name;
        this.typeUser = (typeUser == null) ? 1 : typeUser.getCode();
        this.sellers = sellers;
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

    public Integer getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(Integer typeUser) {
        this.typeUser = typeUser;
    }

    public List<UserData> getSellers() {
        return sellers;
    }

    public void setSellers(List<UserData> sellers) {
        this.sellers = sellers;
    }

    public void addNewSeller(UserData seller) {
        this.sellers.add(seller);
    }
}
