package com.agsr.statistics.controller;

import com.agsr.statistics.dto.SensorStatisticsDto;
import com.agsr.statistics.service.SensorStatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/statistics")
@RequiredArgsConstructor
public class StatisticsController {

	private final SensorStatisticsService service;

	@GetMapping
	public List<SensorStatisticsDto> findAllByDates(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
		return service.findAllByDates(startDate, endDate);
	}

}
