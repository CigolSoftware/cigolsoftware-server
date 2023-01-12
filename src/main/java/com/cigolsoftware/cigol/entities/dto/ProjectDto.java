package com.cigolsoftware.cigol.entities.dto;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.util.StringUtils;

import jakarta.validation.constraints.NotEmpty;

public class ProjectDto {

	protected Long id;

	@NotEmpty
	protected String name;

	public Long getId() {
		return Optional.ofNullable(this.id).orElse(0L);
	}

	public String getName() {
		return String.join(" ", Arrays.asList(this.name.split(" ")).stream().filter(s -> !s.trim().isEmpty())
				.map(s -> StringUtils.capitalize(s.toLowerCase())).toList());
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
