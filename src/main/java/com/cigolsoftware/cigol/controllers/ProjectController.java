package com.cigolsoftware.cigol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cigolsoftware.cigol.dto.Body;
import com.cigolsoftware.cigol.dto.Filter;
import com.cigolsoftware.cigol.dto.Page;
import com.cigolsoftware.cigol.entities.dto.ProjectDto;
import com.cigolsoftware.cigol.enums.Reply;
import com.cigolsoftware.cigol.services.ProjectService;
import com.cigolsoftware.cigol.utilities.Constants;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RequestMapping(Constants.Mapping.PROJECTS)
@RestController
public class ProjectController {

	@Autowired
	private ProjectService service;

	@DeleteMapping(Constants.Mapping.DELETE)
	public ResponseEntity<Body<Void>> delete(@PathVariable final Long id) {
		this.service.delete(id);
		return Body.ok(Reply.OK);
	}

	@PostMapping(Constants.Mapping.EXISTS)
	public ResponseEntity<Body<Boolean>> exists(@RequestBody @Valid final ProjectDto dto) {
		return Body.ok(this.service.exists(dto));
	}

	@PostMapping(Constants.Mapping.FILTER)
	public ResponseEntity<Body<Page>> filter(@RequestBody @Valid final Filter filter) {
		return Body.ok(this.service.filter(filter));
	}

	@PostMapping(Constants.Mapping.SAVE)
	public ResponseEntity<Body<ProjectDto>> save(@RequestBody @Valid final ProjectDto dto) {
		return Body.ok(this.service.save(dto));
	}

}
