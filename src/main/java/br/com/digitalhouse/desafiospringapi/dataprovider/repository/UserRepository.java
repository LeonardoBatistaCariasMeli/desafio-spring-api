package br.com.digitalhouse.desafiospringapi.dataprovider.repository;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
}
