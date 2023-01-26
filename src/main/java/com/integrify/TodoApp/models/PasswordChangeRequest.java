package com.integrify.TodoApp.models;

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
public class PasswordChangeRequest {

    @NotEmpty
    @NonNull
    private String oldPassword;
    @NotEmpty
    @NonNull
    private String newPassword;
}
