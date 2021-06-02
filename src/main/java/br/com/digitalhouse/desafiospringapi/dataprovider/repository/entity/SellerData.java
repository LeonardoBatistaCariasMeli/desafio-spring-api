package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "SELLER")
public class SellerData extends UserData {

    @ManyToMany
    @JoinTable(name = "USER_FOLLOWED",
            joinColumns = @JoinColumn(name = "userFollowId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private List<UserData> followers = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ProductData> products = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<PostData> posts = new ArrayList<>();

    public SellerData() {
    }

    public SellerData(Integer userId, String name, TypeUser typeUser, List<UserData> followed, List<UserData> followers, List<ProductData> products, List<PostData> posts) {
        super(userId, name, typeUser, followed);
        this.followers = followers;
        this.products = products;
        this.posts = posts;
    }

    public List<UserData> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserData> followers) {
        this.followers = followers;
    }

    public List<ProductData> getProducts() {
        return products;
    }

    public void setProducts(List<ProductData> products) {
        this.products = products;
    }

    public List<PostData> getPosts() {
        return posts;
    }

    public void setPosts(List<PostData> posts) {
        this.posts = posts;
    }
}
