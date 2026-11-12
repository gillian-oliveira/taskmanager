package com.oliveira.gillian.taskmanager.backend.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public abstract class AuditableEntity {
	
	@Column(name="created_at", nullable = false, updatable = false)
	private Instant createdAt;
	
	@Column(name = "updated_at")
	private Instant updatedAt;
	
	@Column(name = "deleted_at")
	private Instant deletedAt;
	
	@PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }
	
	@PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now();
    }

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public Instant getDeletedAt() {
		return deletedAt;
	}
	
	public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }
}
