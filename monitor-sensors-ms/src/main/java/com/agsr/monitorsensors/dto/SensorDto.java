package com.agsr.monitorsensors.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;

	@NotNull(
		message = "Name must be not null."
	)
	@Size(
		min = 3,
		max = 30,
		message = "Name length must be more than 3 symbols and smaller than 30 symbols."
	)
	private String name;
	@NotNull(
		message = "Model must be not null."
	)
	@Size(
		max = 15,
		message = "Model length must be smaller than 15 symbols."
	)
	private String model;
	private Range range;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String type;
	@NotNull(
		message = "Type must be not null."
	)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long typeId;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String unit;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long unitId;
	@Size(
		max = 40,
		message = "Location length must be smaller than 15 symbols."
	)
	private String location;
	@Size(
		max = 200,
		message = "Description length must be smaller than 15 symbols."
	)
	private String description;

	@Getter
	@Setter
	public static class Range {
		@NotNull(
			message = "Range from must be not null."
		)
		@Positive(message = "Range from must be a positive number.")
		private int from;
		@NotNull(
			message = "Range to must be not null."
		)
		@Positive(message = "Range to must be a positive number.")
		private int to;

	}

	@JsonIgnore
	@AssertTrue(message = "Range from must be less than to.")
	public boolean isFromLessThanTo() {
		return range.from < range.to;
	}

}
