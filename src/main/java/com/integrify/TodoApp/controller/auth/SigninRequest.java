package com.integrify.TodoApp.controller.auth;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SigninRequest {
    @NotEmpty
    @NonNull
    private String email;
    @NotEmpty
    @NonNull
    private String password;
}
