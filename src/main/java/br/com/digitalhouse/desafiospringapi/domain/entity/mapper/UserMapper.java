package br.com.digitalhouse.desafiospringapi.domain.entity.mapper;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import br.com.digitalhouse.desafiospringapi.domain.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface UserMapper {

    static User fromUserData(UserData data) {
        var following = assemblesFollowingOrFollowersListOf(data.getFollowed());
        var followers =  assemblesFollowingOrFollowersListOf(data.getFollowers());
        return new User(data.getUserId(), data.getName(),data.getTypeUser(), following, followers, 0);
    }

    static List<User> assemblesFollowingOrFollowersListOf(List<UserData> listData) {
        if(listData.isEmpty()) {
            return new ArrayList<>();
        }
        return listData.stream().map(UserMapper::assemblesFollowingOrFollowersOf).collect(Collectors.toList());
    }

    static User assemblesFollowingOrFollowersOf(UserData data) {
        return new User(data.getUserId(), data.getName(), data.getTypeUser(), new ArrayList<>(), new ArrayList<>(), 0);
    }

    static User fromUserData(UserData data, Integer quantity) {
        var following = new ArrayList<User>();
        var followers = new ArrayList<User>();

        return new User(data.getUserId(), data.getName(), data.getTypeUser(), following, followers, quantity);
    }
}
