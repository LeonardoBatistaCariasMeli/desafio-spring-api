package br.com.digitalhouse.desafiospringapi.domain.entity.mapper;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.PostData;
import br.com.digitalhouse.desafiospringapi.domain.entity.Post;

public interface PostMapper {

    static Post fromPostData(PostData data) {
        var product = ProductMapper.fromProductData(data.getProduct());
        return new Post(data.getPostId(), data.getDate(), data.getCategory(), data.getPrice(), product, null);
    }

}
