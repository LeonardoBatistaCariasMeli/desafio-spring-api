package br.com.digitalhouse.desafiospringapi.dataprovider.repository;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {

    @Query("SELECT CASE WHEN EXISTS (SELECT u.userId FROM UserData u INNER JOIN u.followed f WHERE u.userId = ?1 AND f.userId = ?2) THEN TRUE ELSE FALSE END FROM UserData")
    public Boolean isUserFollowingSeller(Integer userId, Integer userFollowId);

    public Optional<UserData> findByUserIdAndTypeUser(Integer userId, Integer typeUser);

}
