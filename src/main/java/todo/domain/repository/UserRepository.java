package todo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
