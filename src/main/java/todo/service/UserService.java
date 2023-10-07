package todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.domain.model.ToDo;
import todo.domain.model.User;
import todo.domain.repository.ToDoRepository;
import todo.domain.repository.UserRepository;
import todo.request.AddToDoRequest;
import todo.request.AddUserRequest;

import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ToDoRepository toDoRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void addUser(AddUserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public Iterable<ToDo> getAllToDosFromUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        return user.getToDoList();
    }

    public ToDo getToDoById(Long id) {
        return toDoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void addToDo(Long userId, AddToDoRequest toDoRequest) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        ToDo toDo = new ToDo();
        toDo.setName(toDoRequest.getName());
        toDo.setDescription(toDoRequest.getDescription());
        user.getToDoList().add(toDo);
        toDoRepository.save(toDo);
        userRepository.save(user);
    }

    public void toggleToDoCompleted(Long idToDo) {
        ToDo toDo = toDoRepository.findById(idToDo).orElseThrow(NoSuchElementException::new);
        toDo.setCompleted(!toDo.isCompleted());
        toDoRepository.save(toDo);
    }

    public void deleteToDo(Long idUser, Long idToDo) {
        User user = userRepository.findById(idUser).orElseThrow(NoSuchElementException::new);
        ToDo toDo = toDoRepository.findById(idToDo).orElseThrow(NoSuchElementException::new);
        user.getToDoList().remove(toDo);
        toDoRepository.delete(toDo);
        userRepository.save(user);
    }
}
