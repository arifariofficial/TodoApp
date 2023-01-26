package com.integrify.TodoApp.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String todoItem;
    private String todoDescription;
    @CreationTimestamp
    LocalDateTime todoCreatedOn;
    @UpdateTimestamp
    LocalDateTime todoUpdatedOn;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;

}
