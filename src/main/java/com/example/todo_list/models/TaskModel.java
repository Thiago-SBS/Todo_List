package com.example.todo_list.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String title;
    private String description;
    private Boolean isCompleted;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void setTitle(String title) throws Exception{
        if (title.length() > 50) {
            throw new Exception("O campo title deve conter no máximo 50 caracteres.");
        }
        this.title = title;
    }
}
