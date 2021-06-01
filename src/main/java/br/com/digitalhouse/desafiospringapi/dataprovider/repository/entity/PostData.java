package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "POST")
public class PostData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    private Integer category;
    private Double price;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductData product;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    public PostData() {
    }

    public PostData(Integer postId, Integer category, Double price, ProductData product, UserData user) {
        this.postId = postId;
        this.category = category;
        this.price = price;
        this.product = product;
        this.user = user;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductData getProduct() {
        return product;
    }

    public void setProduct(ProductData product) {
        this.product = product;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }
}
