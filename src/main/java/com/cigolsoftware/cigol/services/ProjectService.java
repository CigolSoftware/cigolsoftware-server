package com.cigolsoftware.cigol.services;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cigolsoftware.cigol.dto.Filter;
import com.cigolsoftware.cigol.dto.Page;
import com.cigolsoftware.cigol.entities.Project;
import com.cigolsoftware.cigol.entities.dto.ProjectDto;
import com.cigolsoftware.cigol.repositories.ProjectRepository;
import com.cigolsoftware.cigol.utilities.Constants;
import com.cigolsoftware.cigol.utilities.Tools;

@Service
public class ProjectService extends DaoService<Project, ProjectRepository, ProjectDto> {

	public void delete(final Long id) {
		this.repository.deleteById(id);
	}

	public Page filter(final Filter filter) {
		final var findAll = this.repository.findAll((r, q, b) -> {
			q.orderBy(b.desc(r.get(Constants.Filter.MODIFICATION)));
			return b.and(b.like(b.concat(b.lower(r.get(Constants.Param.NAME)), " "), "%" + String.join("%",
					Optional.ofNullable(filter.getValue()).orElseGet(String::new).toLowerCase().split(new String()))
					+ "%"));
		}, PageRequest.of(filter.getPage(), Optional.ofNullable(filter.getSize()).orElse(Constants.Filter.SIZE)));
		return new Page(findAll.stream().map(p -> Tools.copyProperties(p, new ProjectDto())).toList(),
				findAll.getTotalElements());
	}

}
