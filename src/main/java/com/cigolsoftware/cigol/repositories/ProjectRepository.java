package com.cigolsoftware.cigol.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cigolsoftware.cigol.configurations.Repository;
import com.cigolsoftware.cigol.entities.Project;
import com.cigolsoftware.cigol.utilities.Constants;

public interface ProjectRepository extends Repository<Project>, JpaSpecificationExecutor<Project> {

	@Override
	@Query(nativeQuery = true, value = Constants.Query.EXISTS_PROJECT)
	Boolean exists(@Param(Constants.Param.ID) Long id, @Param(Constants.Param.NAME) String name);

}
