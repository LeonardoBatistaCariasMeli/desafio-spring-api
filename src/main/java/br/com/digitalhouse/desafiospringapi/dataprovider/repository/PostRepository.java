package br.com.digitalhouse.desafiospringapi.dataprovider.repository;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.PostData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostData, Integer> {
}
