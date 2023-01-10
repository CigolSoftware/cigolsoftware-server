package com.cigolsoftware.cigol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cigolsoftware.cigol.entities.dto.ProjectDto;
import com.cigolsoftware.cigol.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repository;

	public Boolean exists(final ProjectDto dto) {
		return this.repository.exists(dto.getId(), dto.getName());
	}

}
