package com.cigolsoftware.cigol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cigolsoftware.cigol.dto.Body;
import com.cigolsoftware.cigol.entities.dto.Dto;
import com.cigolsoftware.cigol.services.DaoService;
import com.cigolsoftware.cigol.utilities.Constants;

import jakarta.validation.Valid;

public class Controller<D extends Dto, S extends DaoService<?, ?, D>> {

	@Autowired
	protected S service;

	@PostMapping(Constants.Mapping.EXISTS)
	public ResponseEntity<Body<Boolean>> exists(@RequestBody @Valid final D dto) {
		return Body.ok(this.service.exists(dto));
	}

}
