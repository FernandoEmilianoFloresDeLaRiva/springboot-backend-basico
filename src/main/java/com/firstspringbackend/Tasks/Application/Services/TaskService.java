package com.firstspringbackend.Tasks.Application.Services;

import com.firstspringbackend.Tasks.Domain.Entities.Task;
import com.firstspringbackend.Tasks.Domain.Repositories.TaskRepository;
import com.firstspringbackend.Tasks.Domain.Repositories.TaskServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements TaskServiceRepository {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(int idTask) {
        return taskRepository.findById(idTask).orElse(null);
    }

    @Override
    public List<Task> getTasksByIdUser(int idUser) {
        return taskRepository.findByIdUser(idUser);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task, int idTask) {
        Task originalTask = taskRepository.findById(idTask).orElse(null);
        if (originalTask == null) return null;
        originalTask.setDescription(task.getDescription());
        originalTask.setTitle(task.getTitle());
        return taskRepository.save(originalTask);
    }

    @Override
    public boolean deleteTask(int idTask) {
        Task task = taskRepository.findById(idTask).orElse(null);
        if( task != null) {
            taskRepository.deleteById(idTask);
            return true;
        }
        return false;
    }
}
