package com.oliveira.gillian.taskmanager.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.gillian.taskmanager.backend.entities.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {

}
