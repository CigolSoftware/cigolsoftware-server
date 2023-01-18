package com.cigolsoftware.cigol.entities.dto;

import java.time.LocalDateTime;
import java.util.Optional;

import com.cigolsoftware.cigol.utilities.Tools;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProjectDto {

	protected Long id;

	protected LocalDateTime modification;

	@NotEmpty
	protected String name;

	public Long getId() {
		return Optional.ofNullable(this.id).orElse(0L);
	}

	public LocalDateTime getModification() {
		return this.modification;
	}

	public String getName() {
		return Tools.capitalizeAll(this.name);
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setModification(final LocalDateTime modification) {
		this.modification = modification;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
