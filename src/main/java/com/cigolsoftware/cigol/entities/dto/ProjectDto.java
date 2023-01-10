package com.cigolsoftware.cigol.entities.dto;

import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.cigolsoftware.cigol.entities.Project;

import jakarta.validation.constraints.NotEmpty;

public class ProjectDto {

	private Long id;

	@NotEmpty
	private String name;

	public Project dao() {
		final var project = new Project();
		BeanUtils.copyProperties(this, project);
		return project;
	}

	public Long getId() {
		return Optional.ofNullable(this.id).orElse(0L);
	}

	public String getName() {
		return this.name;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
