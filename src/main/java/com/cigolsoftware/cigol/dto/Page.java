package com.cigolsoftware.cigol.dto;

import java.util.List;

import com.cigolsoftware.cigol.entities.dto.ProjectDto;

public class Page {

	private List<ProjectDto> projects;

	private Long total;

	public Page(final List<ProjectDto> projects, final Long total) {
		this.projects = projects;
		this.total = total;
	}

	public List<ProjectDto> getProjects() {
		return this.projects;
	}

	public Long getTotal() {
		return this.total;
	}

	public void setProjects(final List<ProjectDto> projects) {
		this.projects = projects;
	}

	public void setTotal(final Long total) {
		this.total = total;
	}

}