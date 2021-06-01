package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface UserDataMapper {

    static UserData fromUser(User user) {
        var followed = fromListUserFollowedOrFollowers(user.getFollowed());
        var followers = fromListUserFollowedOrFollowers(user.getFollowers());
        return new UserData(user.getUserId(), user.getName(), user.getTypeUser(), followed, followers,new ArrayList<>());
    }

    static List<UserData> fromListUserFollowedOrFollowers(List<User> listData) {
        if (listData.isEmpty()) {
            return new ArrayList<>();
        }
        return listData.stream().map(UserDataMapper::fromUserFollowedOrFollowers).collect(Collectors.toList());
    }

    static UserData fromUserFollowedOrFollowers(User user) {
        return new UserData(user.getUserId(), user.getName(), user.getTypeUser(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

}
