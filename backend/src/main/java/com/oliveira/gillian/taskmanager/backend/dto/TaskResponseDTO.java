package com.oliveira.gillian.taskmanager.backend.dto;

import java.time.LocalDateTime;

public record TaskResponseDTO(
		Long id,
		String title,
		String description,
		Long ownerId,
		LocalDateTime deadline
		) {
}
