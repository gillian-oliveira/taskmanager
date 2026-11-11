package com.oliveira.gillian.taskmanager.backend.dto;

import java.util.Set;

import com.oliveira.gillian.taskmanager.backend.entities.enums.Role;

public record UserResponseDTO(
		Long id,
		String email,
		boolean enabled,
		Set<Role> role
		) {
}
