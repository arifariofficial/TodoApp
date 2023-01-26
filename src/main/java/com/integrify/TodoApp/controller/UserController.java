package com.integrify.TodoApp.controller;

import com.integrify.TodoApp.models.AuthResponse;
import com.integrify.TodoApp.models.PasswordChangeRequest;
import com.integrify.TodoApp.models.SigninRequest;
import com.integrify.TodoApp.models.SignupRequest;
import com.integrify.TodoApp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(userService.authenticate(request));
    }

    @PutMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeRequest request, Principal principal){
        return ResponseEntity.ok(userService.changePassword(request, principal));
    }
}


