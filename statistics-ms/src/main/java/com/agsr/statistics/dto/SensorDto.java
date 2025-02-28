package com.agsr.statistics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;

	private String name;
	private String model;
	private Range range;
	private String type;
	private String unit;
	private String location;
	private String description;

	@Getter
	@Setter
	public static class Range {

		private int from;
		private int to;

	}

}
