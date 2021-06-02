package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.mapper;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.CustomerData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.SellerData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import br.com.digitalhouse.desafiospringapi.domain.entity.Seller;
import br.com.digitalhouse.desafiospringapi.domain.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface UserDataMapper {

    static UserData fromUser(User user) {
        var followed = fromListUserFollowedOrFollowers(user.getFollowed());

        if(user.getClass().getSimpleName().equals("Customer")) {
            return new CustomerData(user.getUserId(), user.getName(), user.getTypeUser(), followed);
        } else {
            var seller = (Seller) user;
            var followers = fromListUserFollowedOrFollowers(seller.getFollowers());
            return new SellerData(user.getUserId(), user.getName(), user.getTypeUser(), followed, followers,new ArrayList<>());
        }
    }

    static List<UserData> fromListUserFollowedOrFollowers(List<User> listData) {
        if (listData.isEmpty()) {
            return new ArrayList<>();
        }
        return listData.stream().map(UserDataMapper::fromUserFollowedOrFollowers).collect(Collectors.toList());
    }

    static UserData fromUserFollowedOrFollowers(User user) {

        if(user.getClass().getSimpleName().equals("Customer")) {
            return new CustomerData(user.getUserId(), user.getName(), user.getTypeUser(), new ArrayList<>());
        } else {
            return new SellerData(user.getUserId(), user.getName(), user.getTypeUser(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        }
    }

}
