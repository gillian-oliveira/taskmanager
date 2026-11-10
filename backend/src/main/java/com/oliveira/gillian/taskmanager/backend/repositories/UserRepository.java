package com.oliveira.gillian.taskmanager.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.gillian.taskmanager.backend.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
