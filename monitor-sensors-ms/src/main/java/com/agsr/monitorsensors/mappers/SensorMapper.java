package com.agsr.monitorsensors.mappers;

import com.agsr.monitorsensors.domain.Sensor;
import com.agsr.monitorsensors.domain.SensorType;
import com.agsr.monitorsensors.domain.SensorUnit;
import com.agsr.monitorsensors.dto.SensorDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SensorMapper {

	@Mapping(target = "type", ignore = true)
	@Mapping(target = "unit", ignore = true)
	Sensor toEntity(SensorDto dto);

	@AfterMapping
	default void setTypeAndUnit(@MappingTarget Sensor sensor, SensorDto dto) {
		if (dto.getTypeId() != null) {
			SensorType type = new SensorType();
			type.setId(dto.getTypeId());
			sensor.setType(type);
		}
		if (dto.getUnitId() != null) {
			SensorUnit unit = new SensorUnit();
			unit.setId(dto.getUnitId());
			sensor.setUnit(unit);
		}
	}

	@Mapping(target = "type", source = "type.type")
	@Mapping(target = "typeId", source = "type.id")
	@Mapping(target = "unit", source = "unit.unit")
	@Mapping(target = "unitId", source = "unit.id")
	SensorDto toDto(Sensor entity);

	@Mapping(target = "type", source = "type.type")
	@Mapping(target = "typeId", source = "type.id")
	@Mapping(target = "unit", source = "unit.unit")
	@Mapping(target = "unitId", source = "unit.id")
	List<SensorDto> toListDto(List<Sensor> entities);

}
