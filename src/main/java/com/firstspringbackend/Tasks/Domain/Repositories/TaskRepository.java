package com.firstspringbackend.Tasks.Domain.Repositories;

import com.firstspringbackend.Tasks.Domain.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByIdUser(int idUser);
}
