package com.oliveira.gillian.taskmanager.backend.dto.mappers;

import org.springframework.stereotype.Component;

import com.oliveira.gillian.taskmanager.backend.dto.UserRequestDTO;
import com.oliveira.gillian.taskmanager.backend.dto.UserResponseDTO;
import com.oliveira.gillian.taskmanager.backend.entities.User;

@Component
public class UserMapper {
	
	public User toEntity(UserRequestDTO request) {
		if(request == null) {
			throw new IllegalArgumentException("UserRequestDTO cannot be null");
		}
		User user = new User();
		user.setEmail(request.email());
		user.setPassword(request.password());		
		return user;		
	}
	
	public UserResponseDTO toResponse(User user) {
		if (user == null) {
			return null;
		}
		
		return new UserResponseDTO(
				user.getId(),
				user.getEmail(),
				user.isEnabled(),
				user.getRole()
				);
	}

}
