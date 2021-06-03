package br.com.digitalhouse.desafiospringapi.dataprovider.repository;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.PostData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostData, Integer> {

    @Query("SELECT p FROM PostData p WHERE p.date BETWEEN ?1 AND ?2 AND p.user.userId = ?3")
    public List<PostData> getAllPostsByUserIdOnLastTwoWeeks(LocalDate twoWeeksAgo, LocalDate now, Integer userId);

}