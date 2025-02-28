package com.agsr.statistics.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@Table(name = "sensor_statistics")
@Entity
public class SensorStatistics {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int totalCount;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "type_id")
	private Set<SensorTypeStatistics> sensorTypeStatistics = new HashSet<>();

	private LocalDate createdDate;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SensorStatistics that = (SensorStatistics) o;
		return totalCount == that.totalCount && Objects.equals(id, that.id) && Objects.equals(createdDate, that.createdDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, totalCount, createdDate);
	}

}
