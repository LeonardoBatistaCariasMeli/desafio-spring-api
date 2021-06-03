package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Inheritance
@Entity
@Table(name = "USER")
public abstract class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private Integer typeUser;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_FOLLOWED",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "userFollowId")
    )
    private List<UserData> followed = new ArrayList<>();

    public UserData() {
    }

    public UserData(Integer userId, String name, TypeUser typeUser) {
        this.userId = userId;
        this.name = name;
        this.typeUser = (typeUser == null) ? null : typeUser.getCode();
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

    public List<UserData> getFollowed() {
        return followed;
    }

    public void setFollowed(List<UserData> followed) {
        this.followed = followed;
    }

    public void addNewFollow(UserData data) {
        this.followed.add(data);
    }
}
