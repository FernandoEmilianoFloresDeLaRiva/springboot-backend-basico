package com.firstspringbackend.Tasks.Domain.Repositories;

import com.firstspringbackend.Tasks.Domain.Entities.Task;

import java.util.List;

public interface TaskServiceRepository {
    List<Task> getAllTasks();
    Task getTaskById(int idTask);
    List<Task> getTasksByIdUser(int idUser);
    Task createTask(Task task);
    Task updateTask(Task task, int idTask);
    boolean deleteTask(int idTask);
}