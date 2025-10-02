package com.example.todo_list.controllers;

import com.example.todo_list.models.TaskModel;
import com.example.todo_list.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel task) {
        try {
            TaskModel newTask = taskService.createTask(task);
            return ResponseEntity.ok(newTask);

        } catch (Exception e) {
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks(@RequestParam(required = false) Boolean check) {
        List<TaskModel> tasks = taskService.getAllTasks(check);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> updateTask(@PathVariable UUID id, @RequestBody TaskModel body) {
        try {
            TaskModel attTask = taskService.updateTask(id, body);
            return ResponseEntity.ok(attTask);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/{id}/check")
    public ResponseEntity<TaskModel> toggleTask(@PathVariable UUID id, @RequestBody boolean check) {
        try {
            TaskModel attCheck = taskService.toggleTask(id, check);
            return ResponseEntity.ok(attCheck);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskModel> deleteTask(@PathVariable UUID id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
