package br.com.digitalhouse.desafiospringapi.domain.entity.mapper;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.SellerData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import br.com.digitalhouse.desafiospringapi.domain.entity.Customer;
import br.com.digitalhouse.desafiospringapi.domain.entity.Seller;
import br.com.digitalhouse.desafiospringapi.domain.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface UserMapper {

    static User fromUserData(UserData data) {
        var followed = assemblesFollowingOrFollowersListOf(data.getFollowed());

        try {
            var sellerData = (SellerData) data;
            var followers = assemblesFollowingOrFollowersListOf(sellerData.getFollowers());
            return new Seller(sellerData.getUserId(), sellerData.getName(), sellerData.getTypeUser(), followed, followers);
        } catch (ClassCastException ex) {
            return new Customer(data.getUserId(), data.getName(), data.getTypeUser(), followed);
        }
    }

    static List<User> assemblesFollowingOrFollowersListOf(List<UserData> listData) {
        if (listData.isEmpty()) {
            return new ArrayList<>();
        }
        return listData.stream().map(UserMapper::assemblesFollowingOrFollowersOf).collect(Collectors.toList());
    }

    static User assemblesFollowingOrFollowersOf(UserData data) {
        if (data.getClass().getSimpleName().equals("CustomerData")) {
            return new Customer(data.getUserId(), data.getName(), data.getTypeUser(), new ArrayList<>());
        } else {
            return new Seller(data.getUserId(), data.getName(), data.getTypeUser(), new ArrayList<>(), new ArrayList<>());
        }
    }

}
