package com.agsr.monitorsensors.service;

import com.agsr.monitorsensors.domain.Sensor;
import com.agsr.monitorsensors.dto.SensorDto;
import com.agsr.monitorsensors.mappers.SensorMapper;
import com.agsr.monitorsensors.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {

	private final SensorRepository repository;
	private final SensorMapper mapper;

	@Transactional(readOnly = true)
	public List<SensorDto> findAll() {
		return mapper.toListDto(repository.findAll());
	}

	@Transactional(readOnly = true)
	public List<SensorDto> findByNameAndModel(String name, String model) {
		List<Sensor> sensors;
		if (name == null && model == null) {
			sensors = repository.findAll();
		} else if (model == null) {
			sensors = repository.findAllByNameContaining(name);
		} else if (name == null) {
			sensors = repository.findAllByModelContaining(model);
		} else {
			sensors = repository.findAllByNameContainingAndModelContaining(name, model);
		}
		return mapper.toListDto(sensors);
	}

	@Transactional
	public SensorDto create(SensorDto dto) {
		return mapper.toDto(repository.save(mapper.toEntity(dto)));
	}

	@Transactional
	public SensorDto update(Long id, SensorDto dto) {
		dto.setId(id);
		return create(dto);
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
