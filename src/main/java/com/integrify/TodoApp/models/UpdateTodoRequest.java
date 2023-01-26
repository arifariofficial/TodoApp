package com.integrify.TodoApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTodoRequest {

    private String todoDescription;
    private TodoStatus status;
}
