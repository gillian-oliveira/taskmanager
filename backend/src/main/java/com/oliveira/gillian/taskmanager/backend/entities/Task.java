package com.oliveira.gillian.taskmanager.backend.entities;

import java.util.Objects;

import com.oliveira.gillian.taskmanager.backend.entities.enums.TaskStatus;

public class Task {
	
	private Long id;
	
	private String title;
	
	private String description;
	
	private User owner;
	
	private TaskStatus taskStatus = TaskStatus.PENDING;
	
	public Task() {
	}

	public Task(Long id, String title, String description, User owner) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", owner=" + owner
				+ ", taskStatus=" + taskStatus + "]";
	}

}
