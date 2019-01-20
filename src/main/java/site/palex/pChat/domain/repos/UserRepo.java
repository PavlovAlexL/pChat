package site.palex.pChat.domain.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import site.palex.pChat.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
