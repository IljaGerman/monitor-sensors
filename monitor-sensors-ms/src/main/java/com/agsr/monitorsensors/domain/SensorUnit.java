package com.agsr.monitorsensors.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Table(name = "sensor_unit")
@Entity
public class SensorUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String unit;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SensorUnit that = (SensorUnit) o;
		return Objects.equals(id, that.id) && Objects.equals(unit, that.unit);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, unit);
	}

}
