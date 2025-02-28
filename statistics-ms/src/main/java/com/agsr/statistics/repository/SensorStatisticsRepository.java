package com.agsr.statistics.repository;

import com.agsr.statistics.domain.SensorStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SensorStatisticsRepository extends JpaRepository<SensorStatistics, Long> {

	List<SensorStatistics> findAllByCreatedDateBetween(LocalDate startDate, LocalDate endDate);

}
