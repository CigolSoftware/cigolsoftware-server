package com.cigolsoftware.cigol.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.cigolsoftware.cigol.configurations.ControllerMapping;
import com.cigolsoftware.cigol.dto.Body;
import com.cigolsoftware.cigol.entities.dto.SkillDto;
import com.cigolsoftware.cigol.enums.Reply;
import com.cigolsoftware.cigol.services.SkillService;
import com.cigolsoftware.cigol.utilities.Constants;
import com.cigolsoftware.cigol.utilities.Tools;

import jakarta.validation.Valid;

@ControllerMapping(Constants.Mapping.SKILLS)
public class SkillController extends Controller<SkillDto, SkillService> {

	@Override
	public ResponseEntity<Body<SkillDto>> save(@RequestBody @Valid final SkillDto dto) {
		Tools.ifThrow(dto.getEasy() >= dto.getNormal(), Reply.SKILL_NORMAL);
		Tools.ifThrow(dto.getHard() <= dto.getNormal(), Reply.SKILL_HARD);
		return super.save(dto);
	}
}
