package com.agsr.statistics.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Data
public class SensorStatisticsDto {

	private Long id;
	private int totalCount;
	private Set<SensorTypeStatisticsDto> sensorTypeStatistics = new HashSet<>();
	private LocalDate createdDate;

}
