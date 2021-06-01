package br.com.digitalhouse.desafiospringapi.dataprovider.repository;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {

    public Optional<UserData> findByUserIdAndTypeUser(Integer userId, Integer typeUser);

    @Transactional
    @Query("SELECT count(u.userId) FROM UserData u INNER JOIN u.sellers s WHERE s.userId = ?1")
    public Integer getQuantityUsersFollowSeller(Integer userId);

    @Transactional
    @Query("SELECT CASE WHEN EXISTS (SELECT u.userId FROM UserData u INNER JOIN u.sellers s WHERE u.userId = ?1 AND s.userId = ?2) THEN TRUE ELSE FALSE END FROM UserData")
    public Boolean isUserFollowingSeller(Integer userId, Integer sellerId);

}
