package com.oliveira.gillian.taskmanager.backend.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.oliveira.gillian.taskmanager.backend.entities.enums.Role;


public class User {
	
	private Long id;
	
	private String email;
	
	private String password;
	
	private boolean enabled;	
	
	private Set<Role> role = new HashSet<>();
	
	public User() {
	}

	public User(Long id, String email, String password, boolean enabled) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRole() {
		return role;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", enabled=" + enabled + ", role="
				+ role + "]";
	}	
}
