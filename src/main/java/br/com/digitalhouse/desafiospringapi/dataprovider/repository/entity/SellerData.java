package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "SELLER")
public class SellerData extends UserData {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_FOLLOWED",
            joinColumns = @JoinColumn(name = "userFollowId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private List<UserData> followers = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ProductData> products = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PostData> posts = new ArrayList<>();

    public SellerData() {
    }

    public SellerData(Integer userId, String name, TypeUser typeUser) {
        super(userId, name, typeUser);
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
