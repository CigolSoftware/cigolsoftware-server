package com.cigolsoftware.cigol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cigolsoftware.cigol.dto.Body;
import com.cigolsoftware.cigol.entities.dto.ProjectDto;
import com.cigolsoftware.cigol.services.ProjectService;
import com.cigolsoftware.cigol.utilities.Constants;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RequestMapping(Constants.PROJECTS)
@RestController
public class ProjectController {

	@Autowired
	private ProjectService service;

	@PostMapping(Constants.Mapping.EXISTS)
	public ResponseEntity<Body<Boolean>> exists(@RequestBody @Valid final ProjectDto dto) {
		return Body.ok(this.service.exists(dto));
	}

	@PostMapping(Constants.Mapping.SAVE)
	public ResponseEntity<Body<ProjectDto>> save(@RequestBody @Valid final ProjectDto dto) {
		return Body.ok(this.service.save(dto));
	}

}
