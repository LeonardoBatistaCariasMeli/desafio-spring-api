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
    @JoinTable(name = "USER_FOLLOWED",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "userFollowId")
    )
    private List<UserData> followed = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "USER_FOLLOWED",
            joinColumns = @JoinColumn(name = "userFollowId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private List<UserData> followers = new ArrayList<>();

    public UserData() {
    }

    public UserData(Integer userId, String name, TypeUser typeUser, List<UserData> followed, List<UserData> followers) {
        this.userId = userId;
        this.name = name;
        this.typeUser = (typeUser == null) ? null : typeUser.getCode();
        this.followed = followed;
        this.followers = followers;
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

    public List<UserData> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserData> followers) {
        this.followers = followers;
    }

    public void addNewFollow(UserData data) {
        this.followed.add(data);
    }

}
