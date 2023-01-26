package com.integrify.TodoApp.repositories;

import com.integrify.TodoApp.models.Todo;
import com.integrify.TodoApp.models.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Iterable<Todo>findTodosByStatus(TodoStatus status);
    boolean existsByStatus(TodoStatus status);
    Todo findTodoById(Long id);
}
