package com.agsr.monitorsensors.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
@Table(name = "sensor")
@Entity
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String model;
	@Embedded
	private Range range;
	@ManyToOne
	@JoinColumn(name = "type_id")
	private SensorType type;
	@ManyToOne
	@JoinColumn(name = "unit_id")
	private SensorUnit unit;
	private String location;
	private String description;

	@Embeddable
	@Getter
	@Setter
	public static class Range {
		@Column(name = "range_from")
		private int from;
		@Column(name = "range_to")
		private int to;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Sensor sensor = (Sensor) o;
		return Objects.equals(id, sensor.id) && Objects.equals(name, sensor.name) && Objects.equals(model, sensor.model) && Objects.equals(range, sensor.range) && Objects.equals(type, sensor.type) && Objects.equals(unit, sensor.unit) && Objects.equals(location, sensor.location) && Objects.equals(description, sensor.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, model, range, type, unit, location, description);
	}

}
