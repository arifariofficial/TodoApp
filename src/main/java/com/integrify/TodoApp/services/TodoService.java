package com.integrify.TodoApp.services;

import com.integrify.TodoApp.models.*;
import com.integrify.TodoApp.repositories.TodoRepository;
import com.integrify.TodoApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    public ResponseEntity<?> addTodo(AddTodoRequest addTodoRequest, Principal principal) {
        //Find username
        String username = principal.getName();
        User user = userRepository.findUserByEmail(username);

        var todo = Todo.builder()
                .todoItem(addTodoRequest.getTodoItem())
                .todoDescription(addTodoRequest.getTodoDescription())
                .status(TodoStatus.ONGOING)
                .build();

        user.getTodoList().add(todo);
        todoRepository.save(todo);

        return new ResponseEntity<>("Todo item created", HttpStatus.CREATED);

    }

    public Iterable<Todo> getTodoItems(@RequestParam TodoStatus status) {
        if (todoRepository.existsByStatus(status)) {
            return todoRepository.findTodosByStatus(status);
        } else {
            return todoRepository.findAll();
        }
    }

    public ResponseEntity<?> updateTodo(@PathVariable Long id,
                                        @RequestBody UpdateTodoRequest updateTodoRequest){
       Todo todo = todoRepository.findTodoById(id);
        todo.setTodoDescription(updateTodoRequest.getTodoDescription());
        todo.setStatus(updateTodoRequest.getStatus())
        ;
        //update to do
        todoRepository.save(todo);
        return new ResponseEntity<>("Todo updated", HttpStatus.OK);
    }

    public ResponseEntity<?> updateTodo(@PathVariable Long id, Principal principal){

        Todo todo = todoRepository.findById(id).orElseThrow(NoSuchElementException::new);
        //Get current logged in user
        String username = principal.getName();
        User currentUser = this.userRepository.findUserByEmail(username);
        //Delete todo_items
        currentUser.getTodoList().remove(todo);
        todoRepository.delete(todo);
        return new ResponseEntity<>("Todo deleted", HttpStatus.OK);
    }
}
