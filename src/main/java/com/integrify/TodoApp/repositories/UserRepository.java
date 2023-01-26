package com.integrify.TodoApp.repositories;

import com.integrify.TodoApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findByEmail(String email);
    Boolean existsByPassword(String password);
    Boolean existsByEmail(String email);
    User findUserByEmail(String email);
}
