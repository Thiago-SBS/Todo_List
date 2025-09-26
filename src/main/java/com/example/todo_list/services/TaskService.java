package com.example.todo_list.services;

import com.example.todo_list.models.TaskModel;
import com.example.todo_list.repositorys.ITaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class TaskService {

    @Autowired
    private ITaskRepository iTaskRepository;

    public TaskService(ITaskRepository taskRepository) {
        this.iTaskRepository = taskRepository;
    }

    public TaskModel createTask(TaskModel task) {
        if (task.getIsCompleted() == null) {
            task.setIsCompleted(false);
        }

        task.setCreatedAt(LocalDateTime.now());

        return iTaskRepository.save(task);
    }

    public List<TaskModel> getAllTasks(Boolean check) {
        if (check == null) {
            return iTaskRepository.findAll();
        } else {
            return iTaskRepository.findByCheck(check);
        }
    }

    public TaskModel updateTask(UUID id, TaskModel updatedTask) {
        log.info("Iniciando serviço de atualização de task");
        Optional<TaskModel> task = iTaskRepository.findById(id);

        if (task.isEmpty()) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }

        TaskModel taskFind = task.get();

        try {
            log.info("Iniciando mudança de informação na task de ID: " + id);
            if (taskFind.getTitle() != null) {
                log.info("Iniciando troca de informação de titulo");
                taskFind.setTitle(updatedTask.getTitle());
            }

            if (taskFind.getDescription() != null) {
                log.info("Iniciando troca de informação da descrição");
                taskFind.setDescription(updatedTask.getDescription());
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar título: " + e.getMessage());
        }

        taskFind.setUpdatedAt(LocalDateTime.now());

        log.info("Iniciando atualizações de dados no banco");
        return iTaskRepository.save(taskFind);
    }

    public TaskModel toggleTask(UUID id, boolean check) {
        Optional<TaskModel> task = iTaskRepository.findById(id);

        if (task.isEmpty()) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }

        TaskModel taskFind = task.get();

        if (taskFind.getIsCompleted() == false) {
            taskFind.setIsCompleted(true);
        } else {
            taskFind.setIsCompleted(false);
        }

        taskFind.setUpdatedAt(LocalDateTime.now());

        return iTaskRepository.save(taskFind);
    }

    public void deleteTask(UUID id) {
        if (!iTaskRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }
        iTaskRepository.deleteById(id);
    }
}
