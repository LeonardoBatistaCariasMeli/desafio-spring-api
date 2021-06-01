package br.com.digitalhouse.desafiospringapi.domain.entity.mapper;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import br.com.digitalhouse.desafiospringapi.domain.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface UserMapper {

    static User fromUserData(UserData data) {
        var sellers = assemblesSellersListOf(data.getSellers());
        return new User(data.getUserId(), data.getName(),data.getTypeUser(), sellers, 0);
    }

    static List<User> assemblesSellersListOf(List<UserData> listData) {
        return listData.stream().map(UserMapper::assembleSellerOf).collect(Collectors.toList());
    }

    static User assembleSellerOf(UserData data) {
        return new User(data.getUserId(), data.getName(), data.getTypeUser(), new ArrayList<>(), 0);
    }

    static User fromUserData(UserData data, Integer quantity) {
        var sellers = assemblesSellersListOf(data.getSellers());
        return new User(data.getUserId(), data.getName(), data.getTypeUser(), sellers, quantity);
    }
}
