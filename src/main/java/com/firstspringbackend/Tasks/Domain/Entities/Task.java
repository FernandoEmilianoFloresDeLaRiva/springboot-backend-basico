package com.firstspringbackend.Tasks.Domain.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idTask;
    @Column(name = "idUser", nullable = false)
    int idUser;
    @Column(name = "Title", nullable = false, length = 50)
    String title;
    @Column(name = "Description")
    String description;

    public Task(int idTask, int idUser, String title, String description) {
        this.idTask = idTask;
        this.idUser = idUser;
        this.title = title;
        this.description = description;
    }

    public Task() {

    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
