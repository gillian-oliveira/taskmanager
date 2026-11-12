package com.oliveira.gillian.taskmanager.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oliveira.gillian.taskmanager.backend.dto.UserRequestDTO;
import com.oliveira.gillian.taskmanager.backend.dto.UserResponseDTO;
import com.oliveira.gillian.taskmanager.backend.dto.mappers.UserMapper;
import com.oliveira.gillian.taskmanager.backend.entities.User;
import com.oliveira.gillian.taskmanager.backend.repositories.UserRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	private UserMapper userMapper;
	
	//private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
	
	//TODO: Falta encriptar senha
	@Transactional
	public UserResponseDTO createUser(UserRequestDTO request) {
		User user = userMapper.toEntity(request);
		user.setPassword(request.password());
		User savedUser = userRepository.save(user);
		return userMapper.toResponse(savedUser);
	}
	
	@Transactional(readOnly = true)
	public Page<UserResponseDTO> findAllByPaged(Pageable pageable) {
		Page<User> page = userRepository.findAllByEnabledIsTrue(pageable);
		return page.map(userMapper::toResponse);
	}
	
}
