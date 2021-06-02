package br.com.digitalhouse.desafiospringapi.usecase.model.response;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class SellerResponse extends UserResponse{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UserResponse> followers = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer quantityFollowers;

    public SellerResponse(Integer userId, String name, TypeUser typeuser, List<UserResponse> followed, List<UserResponse> followers, Integer quantityFollowers) {
        super(userId, name, typeuser, followed);
        this.followers = followers;
        this.quantityFollowers = quantityFollowers;
    }

    public List<UserResponse> getFollowers() {
        return followers;
    }

    public Integer getQuantityFollowers() {
        return quantityFollowers;
    }

    public void setFollowers(List<UserResponse> followers) {
        this.followers = followers;
    }

    public void setQuantityFollowers(Integer quantityFollowers) {
        this.quantityFollowers = quantityFollowers;
    }
}
