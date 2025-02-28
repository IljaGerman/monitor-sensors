package com.agsr.statistics.client;

import com.agsr.statistics.config.FeignConfig;
import com.agsr.statistics.dto.SensorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "monitor-sensors-ms", url = "${sensors.service.path}", configuration = FeignConfig.class)
public interface SensorClient {

	@GetMapping("api/v1/monitor-sensors")
	List<SensorDto> findAll();

}
