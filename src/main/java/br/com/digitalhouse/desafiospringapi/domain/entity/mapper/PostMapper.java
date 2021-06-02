package br.com.digitalhouse.desafiospringapi.domain.entity.mapper;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.PostData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import br.com.digitalhouse.desafiospringapi.domain.entity.Post;
import br.com.digitalhouse.desafiospringapi.domain.entity.Seller;
import br.com.digitalhouse.desafiospringapi.domain.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface PostMapper {

    static List<Post> fromListPostData(List<PostData> listData) {
        if (listData.isEmpty()) {
            return new ArrayList<>();
        }

        return listData.stream().map(PostMapper::fromPostData).collect(Collectors.toList());
    }

    static Post fromPostData(PostData data) {
        var product = ProductMapper.fromProductData(data.getProduct());
        var user = assembleUserOf(data.getUser());
        return new Post(data.getPostId(), data.getDate(), data.getCategory(), data.getPrice(), product, user);
    }

    static User assembleUserOf(UserData data) {
        return new Seller(data.getUserId(), data.getName(), data.getTypeUser(), null, null);
    }

}
