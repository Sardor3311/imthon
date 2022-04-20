package imtixon.uz.start_up.repository;

import imtixon.uz.start_up.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserName(String userName);
    User findByUserName (String userName);
}
