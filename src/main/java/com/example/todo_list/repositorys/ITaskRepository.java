package com.example.todo_list.repositorys;

import com.example.todo_list.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    List<TaskModel> findByCheck(boolean check);
}
