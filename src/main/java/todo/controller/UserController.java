package todo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.domain.model.ToDo;
import todo.domain.model.User;
import todo.request.AddToDoRequest;
import todo.request.AddUserRequest;
import todo.service.UserService;

@RestController
@RequestMapping("/users")
@Tag(name = "To Do App REST API")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Returns all users from the database", method = "GET")
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(summary = "Return a user passing the id", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Operation(summary = "Add a user", method = "POST")
    @PostMapping
    public void addUser(@RequestBody AddUserRequest userRequest) {
        userService.addUser(userRequest);
    }

    @Operation(summary = "Delete a user", method = "DELETE")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @Operation(summary = "Returns all To Dos from a user passing the id", method = "GET")
    @GetMapping("{userId}/todos")
    public ResponseEntity<Iterable<ToDo>> getAllToDos(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getAllToDosFromUser(userId));
    }

    @Operation(summary = "Return a To Do passing the id", method = "GET")
    @GetMapping("/todos/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getToDoById(id));
    }

    @Operation(summary = "Add a To Do into a user passing the id", method = "POST")
    @PostMapping("{userId}/todos")
    public void addToDo(@PathVariable Long userId, @RequestBody AddToDoRequest toDoRequest) {
        userService.addToDo(userId, toDoRequest);
    }

    @Operation(summary = "Toggle the completed field of a To Do passing the id", method = "POST")
    @PostMapping("/todos/{id}")
    public void toggleToDoCompleted(@PathVariable Long id) {
        userService.toggleToDoCompleted(id);
    }

    @Operation(summary = "Delete a To Do passing the id of the user and the id of the To Do", method = "DELETE")
    @DeleteMapping("/{userId}/todos/{toDoId}")
    public void deleteToDo(@PathVariable Long userId, @PathVariable Long toDoId) {
        userService.deleteToDo(userId, toDoId);
    }
}
