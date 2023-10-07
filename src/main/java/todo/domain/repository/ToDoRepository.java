package todo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.domain.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
