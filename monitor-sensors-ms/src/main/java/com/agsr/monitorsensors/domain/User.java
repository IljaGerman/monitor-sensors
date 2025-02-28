package com.agsr.monitorsensors.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Table(name = "users")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;
	private String password;
	private String role;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, password, role);
	}
}
