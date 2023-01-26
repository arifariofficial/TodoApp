package com.integrify.TodoApp.controller;

import com.integrify.TodoApp.models.AddTodoRequest;
import com.integrify.TodoApp.models.Todo;
import com.integrify.TodoApp.models.TodoStatus;
import com.integrify.TodoApp.models.UpdateTodoRequest;
import com.integrify.TodoApp.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping()
    public ResponseEntity<?> addTodo(@RequestBody AddTodoRequest addTodoRequest, Principal principal) {
        return ResponseEntity.ok(todoService.addTodo(addTodoRequest, principal));
    }

    @GetMapping()
    public Iterable<Todo> getTodoItems(@RequestParam TodoStatus status) {
        return todoService.getTodoItems(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id,
                                        @RequestBody UpdateTodoRequest updateTodoRequest){
        return ResponseEntity.ok(todoService.updateTodo(id,updateTodoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id, Principal principal){
        return ResponseEntity.ok(todoService.updateTodo(id, principal));
    }
}
