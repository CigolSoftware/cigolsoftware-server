package com.cigolsoftware.cigol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cigolsoftware.cigol.configurations.ControlledException;
import com.cigolsoftware.cigol.entities.Project;
import com.cigolsoftware.cigol.entities.dto.ProjectDto;
import com.cigolsoftware.cigol.enums.Reply;
import com.cigolsoftware.cigol.repositories.ProjectRepository;
import com.cigolsoftware.cigol.utilities.Tools;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repository;

	public Boolean exists(final ProjectDto dto) {
		return this.repository.exists(dto.getId(), dto.getName());
	}

	public ProjectDto save(final ProjectDto dto) {
		if (Boolean.TRUE.equals(this.exists(dto))) {
			throw new ControlledException(Reply.EXISTS);
		}
		return Tools.copyProperties(this.repository.save(Tools.copyProperties(dto, new Project())), new ProjectDto());
	}

}
