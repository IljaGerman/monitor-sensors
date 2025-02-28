package com.agsr.statistics.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Table(name = "sensor_type_statistics")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SensorTypeStatistics {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String type;
	private long count;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SensorTypeStatistics that = (SensorTypeStatistics) o;
		return count == that.count && Objects.equals(id, that.id) && Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type, count);
	}

}
