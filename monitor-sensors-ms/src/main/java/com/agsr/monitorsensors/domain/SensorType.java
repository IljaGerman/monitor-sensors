package com.agsr.monitorsensors.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Table(name = "sensor_type")
@Entity
public class SensorType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String type;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SensorType that = (SensorType) o;
		return Objects.equals(id, that.id) && Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}

}
