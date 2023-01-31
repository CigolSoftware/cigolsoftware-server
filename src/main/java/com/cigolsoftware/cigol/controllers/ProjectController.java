package com.cigolsoftware.cigol.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cigolsoftware.cigol.configurations.ControllerMapping;
import com.cigolsoftware.cigol.dto.Body;
import com.cigolsoftware.cigol.dto.Filter;
import com.cigolsoftware.cigol.dto.Page;
import com.cigolsoftware.cigol.entities.dto.ProjectDto;
import com.cigolsoftware.cigol.enums.Reply;
import com.cigolsoftware.cigol.services.ProjectService;
import com.cigolsoftware.cigol.utilities.Constants;

import jakarta.validation.Valid;

@ControllerMapping(Constants.Mapping.PROJECTS)
public class ProjectController extends Controller<ProjectDto, ProjectService> {

	@DeleteMapping(Constants.Mapping.DELETE)
	public ResponseEntity<Body<Void>> delete(@PathVariable final Long id) {
		this.service.delete(id);
		return Body.ok(Reply.OK);
	}

	@PostMapping(Constants.Mapping.FILTER)
	public ResponseEntity<Body<Page>> filter(@RequestBody @Valid final Filter filter) {
		return Body.ok(this.service.filter(filter));
	}

}
