package com.oliveira.gillian.taskmanager.backend.services;

import org.springframework.stereotype.Service;

import com.oliveira.gillian.taskmanager.backend.dto.UserRequestDTO;
import com.oliveira.gillian.taskmanager.backend.dto.UserResponseDTO;
import com.oliveira.gillian.taskmanager.backend.dto.mappers.UserMapper;
import com.oliveira.gillian.taskmanager.backend.entities.User;
import com.oliveira.gillian.taskmanager.backend.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	private UserMapper userMapper;
	
	//private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
	
	@Transactional
	public UserResponseDTO createUser(UserRequestDTO request) {
		User user = userMapper.toEntity(request);
		user.setPassword(request.password());
		User savedUser = userRepository.save(user);
		return userMapper.toResponse(savedUser);
	}
}
