package com.oliveira.gillian.taskmanager.backend.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TaskRequestDTO(
		@NotBlank(message = "The title cannot be blank")
		@Size(max = 100, message = "The title must have a maximum of 100 characters")
		String title,
				
		String description,
		
		@NotNull(message = "The task owner's ID is required")
		Long ownerId,
		
		@NotNull(message = "Mandatory deadline")
		@Future(message = "The task deadline must be a future date")
		LocalDateTime deadline
		) {
}
