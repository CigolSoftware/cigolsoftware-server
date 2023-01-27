package com.cigolsoftware.cigol.controllers;

import com.cigolsoftware.cigol.configurations.ControllerMapping;
import com.cigolsoftware.cigol.entities.dto.SkillDto;
import com.cigolsoftware.cigol.services.SkillService;
import com.cigolsoftware.cigol.utilities.Constants;

@ControllerMapping(Constants.Mapping.SKILLS)
public class SkillController extends Controller<SkillDto, SkillService> {
}
