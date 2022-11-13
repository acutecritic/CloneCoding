package crud.team.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;
import crud.team.entity.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByName(String name);
}
