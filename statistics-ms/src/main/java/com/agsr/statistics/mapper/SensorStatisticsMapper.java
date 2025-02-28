package com.agsr.statistics.mapper;

import com.agsr.statistics.domain.SensorStatistics;
import com.agsr.statistics.dto.SensorStatisticsDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SensorStatisticsMapper {

	List<SensorStatisticsDto> toListDto(List<SensorStatistics> entities);

}
