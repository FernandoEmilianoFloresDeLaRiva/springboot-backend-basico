package com.firstspringbackend.Tasks.Infraestructure.Controllers;

import com.firstspringbackend.Tasks.Application.TaskService;
import com.firstspringbackend.Tasks.Domain.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") int idTask){
        return taskService.getTaskById(idTask);
    }
    @GetMapping("/user/{idUser}")
    public List<Task> getTasksByIdUser(@PathVariable("idUser") int idUser){
        return taskService.getTasksByIdUser(idUser);
    }
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }
    @PutMapping("/{idTask}")
    public Task updateTask (@RequestBody Task task, @PathVariable("idTask") int idTask){
        return taskService.updateTask(task, idTask);
    }

    @DeleteMapping("/{idTask}")
    public String deleteTask (@PathVariable("idTask") int idTask) {
        if (taskService.deleteTask(idTask)) return "Task with id "+idTask+" deleted succesfully!";
        return "Task with id "+idTask+" not found!";
    }
}
