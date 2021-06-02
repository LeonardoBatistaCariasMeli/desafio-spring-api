package br.com.digitalhouse.desafiospringapi.domain.entity.mapper;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.ProductData;
import br.com.digitalhouse.desafiospringapi.domain.entity.Product;

public class ProductMapper {

    static Product fromProductData(ProductData data) {
        return new Product(data.getProductId(), data.getProductName(), data.getType(), data.getBrand(), data.getColor(), data.getNotes());
    }

}
