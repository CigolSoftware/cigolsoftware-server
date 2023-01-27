package com.cigolsoftware.cigol.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cigolsoftware.cigol.configurations.Repository;
import com.cigolsoftware.cigol.entities.Skill;
import com.cigolsoftware.cigol.utilities.Constants;

public interface SkillRepository extends Repository<Skill> {

	@Override
	@Query(nativeQuery = true, value = Constants.Query.EXISTS_SKILL)
	Boolean exists(@Param(Constants.Param.ID) Long id, @Param(Constants.Param.NAME) String name);

}
