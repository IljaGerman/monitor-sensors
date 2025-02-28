package com.agsr.monitorsensors.repository;

import com.agsr.monitorsensors.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

	List<Sensor> findAllByNameContainingAndModelContaining(String name, String model);

	List<Sensor> findAllByNameContaining(String name);

	List<Sensor> findAllByModelContaining(String model);

}
