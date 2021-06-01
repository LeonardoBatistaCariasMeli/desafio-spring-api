package br.com.digitalhouse.desafiospringapi.dataprovider.repository;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.SellerData;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends UsersRepository<SellerData> {
}
