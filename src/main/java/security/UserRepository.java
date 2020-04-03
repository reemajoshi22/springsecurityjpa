package security;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import security.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String userName);
}
