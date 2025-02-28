package com.agsr.monitorsensors.controller;

import com.agsr.monitorsensors.dto.SensorDto;
import com.agsr.monitorsensors.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/monitor-sensors")
@RequiredArgsConstructor
@SecurityRequirement(name = "basicAuth")
public class SensorController {

	private final SensorService service;

	@Operation(summary = "Getting all monitor sensors")
	@PreAuthorize("hasAnyAuthority('ROLE_VIEWER', 'ROLE_ADMIN')")
	@GetMapping
	public List<SensorDto> findAll() {
		return service.findAll();
	}

	@Operation(summary = "Getting monitor sensors by name and model")
	@PreAuthorize("hasAnyAuthority('ROLE_VIEWER', 'ROLE_ADMIN')")
	@GetMapping("/params")
	public List<SensorDto> findByNameAndModel(@RequestParam(value = "name", required = false) String name,
											  @RequestParam(value = "model", required = false) String model) {
		return service.findByNameAndModel(name, model);
	}

	@Operation(summary = "Create sensor (for admin)")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping
	public SensorDto create(@Valid @RequestBody SensorDto dto) {
		log.info("Received request: {}", dto);
		return service.create(dto);
	}

	@Operation(summary = "Update sensor (for admin)")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PutMapping("/{id}")
	public SensorDto update(@PathVariable Long id, @RequestBody SensorDto dto) {
		return service.update(id, dto);
	}

	@Operation(summary = "Delete sensor (for admin)")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
