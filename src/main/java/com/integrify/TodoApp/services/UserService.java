package com.integrify.TodoApp.services;

import com.integrify.TodoApp.models.AuthResponse;
import com.integrify.TodoApp.models.PasswordChangeRequest;
import com.integrify.TodoApp.models.SigninRequest;
import com.integrify.TodoApp.models.SignupRequest;
import com.integrify.TodoApp.models.Role;
import com.integrify.TodoApp.models.User;
import com.integrify.TodoApp.repositories.UserRepository;
import com.integrify.TodoApp.services.config.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<String> register(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return new ResponseEntity<String>("Email already taken", HttpStatus.CREATED);
        }

        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return new ResponseEntity<String>("User Created Successfully", HttpStatus.CREATED);

    }

    public AuthResponse authenticate(SigninRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid User / Password"));

        var jwtToken = jwtUtils.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public ResponseEntity<?> changePassword(PasswordChangeRequest request, Principal principal) {

        //Get current logged in user
        String username = principal.getName();
        User currentUser = this.userRepository.findUserByEmail(username);

        //Check if old password matches
        if (this.passwordEncoder.matches(request.getOldPassword(), currentUser.getPassword())) {
            currentUser.setPassword(request.getNewPassword());
        }else {
            return new ResponseEntity<>("Existing password do not match", HttpStatus.BAD_REQUEST);
        }

        //Save new password
        userRepository.save(currentUser);

        //Create new JTW token for the user with new password
        var jwtToken = jwtUtils.generateToken(currentUser);

        return ResponseEntity.ok(AuthResponse.builder()
                    .token(jwtToken)
                    .build());
    }
}


