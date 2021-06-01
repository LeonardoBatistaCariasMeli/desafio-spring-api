package br.com.digitalhouse.desafiospringapi.dataprovider.repository;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductData, Integer> {
}
