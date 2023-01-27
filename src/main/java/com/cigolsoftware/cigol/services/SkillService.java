package com.cigolsoftware.cigol.services;

import org.springframework.stereotype.Service;

import com.cigolsoftware.cigol.entities.Skill;
import com.cigolsoftware.cigol.entities.dto.SkillDto;
import com.cigolsoftware.cigol.repositories.SkillRepository;

@Service
public class SkillService extends DaoService<Skill, SkillRepository, SkillDto> {

}
