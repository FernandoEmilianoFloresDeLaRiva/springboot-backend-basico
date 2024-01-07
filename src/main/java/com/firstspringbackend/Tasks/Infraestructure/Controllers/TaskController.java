package com.firstspringbackend.Tasks.Infraestructure.Controllers;

import com.firstspringbackend.Tasks.Application.Services.TaskService;
import com.firstspringbackend.Tasks.Domain.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping
    public  ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.status(200).body(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") int idTask){
        Task task = taskService.getTaskById(idTask);
        return ResponseEntity.status(200).body(task);
    }
    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<Task>> getTasksByIdUser(@PathVariable("idUser") int idUser){
        List<Task> tasksByUser = taskService.getTasksByIdUser(idUser);
        return ResponseEntity.status(200).body(tasksByUser);
    }
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task newTask = taskService.createTask(task);
        return ResponseEntity.status(201).body(newTask);
    }
    @PutMapping("/{idTask}")
    public ResponseEntity<Task> updateTask (@RequestBody Task task, @PathVariable("idTask") int idTask){
        Task updatedTask = taskService.updateTask(task, idTask);
        return ResponseEntity.status(200).body(updatedTask);
    }

    @DeleteMapping("/{idTask}")
    public ResponseEntity<String> deleteTask (@PathVariable("idTask") int idTask) {
        if (taskService.deleteTask(idTask)) return ResponseEntity.status(200).body("Task with id "+idTask+" deleted succesfully!");
        return ResponseEntity.status(404).body("Task with id "+idTask+" not found!");
    }
}
