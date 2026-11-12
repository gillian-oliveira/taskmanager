package com.oliveira.gillian.taskmanager.backend.controllers;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oliveira.gillian.taskmanager.backend.dto.UserRequestDTO;
import com.oliveira.gillian.taskmanager.backend.dto.UserResponseDTO;
import com.oliveira.gillian.taskmanager.backend.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> createUser(
			@RequestBody @Valid UserRequestDTO dto) {
		UserResponseDTO createdUser = userService.createUser(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdUser.id())
				.toUri();
		return ResponseEntity.created(uri).body(createdUser);
	}
	
	@GetMapping("/active")
	public ResponseEntity<Page<UserResponseDTO>> findAllActivePaged(
			@PageableDefault(page = 0, size = 10, sort = "createdAt") Pageable pageable) {
		Page<UserResponseDTO> activeUsersPage = userService.findAllActivePaged(pageable);
		return ResponseEntity.ok(activeUsersPage);	
	}
	
	

}
