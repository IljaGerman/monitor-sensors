package com.agsr.statistics.service;

import com.agsr.statistics.client.SensorClient;
import com.agsr.statistics.domain.SensorStatistics;
import com.agsr.statistics.domain.SensorTypeStatistics;
import com.agsr.statistics.dto.SensorDto;
import com.agsr.statistics.dto.SensorStatisticsDto;
import com.agsr.statistics.mapper.SensorStatisticsMapper;
import com.agsr.statistics.repository.SensorStatisticsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorStatisticsService {

	private final SensorStatisticsRepository repository;
	private final SensorClient sensorClient;
	private final SensorStatisticsMapper mapper;

	@Transactional(readOnly = true)
	public List<SensorStatisticsDto> findAllByDates(LocalDate startDate, LocalDate endDate) {
		return mapper.toListDto(repository.findAllByCreatedDateBetween(startDate, endDate));
	}

	@Transactional
	@Scheduled(cron = "0 0 2 * * ?")
	public void getSensorInfo() {
		log.info("Get info: {}", LocalDate.now());
		List<SensorDto> sensorDtoList = sensorClient.findAll();
		SensorStatistics sensorStatistics = new SensorStatistics();
		sensorStatistics.setTotalCount(sensorDtoList.size());
		sensorStatistics.setSensorTypeStatistics(
			sensorDtoList
				.stream()
				.collect(Collectors.groupingBy(SensorDto::getType, Collectors.counting()))
				.entrySet()
				.stream()
				.map(e -> new SensorTypeStatistics(null, e.getKey(), e.getValue()))
				.collect(Collectors.toSet())
		);
		sensorStatistics.setCreatedDate(LocalDate.now());
		repository.save(sensorStatistics);
		log.info("Info saved: {}", sensorStatistics);
	}

}
