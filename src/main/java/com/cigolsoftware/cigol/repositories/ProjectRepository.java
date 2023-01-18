package com.cigolsoftware.cigol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cigolsoftware.cigol.entities.Project;
import com.cigolsoftware.cigol.utilities.Constants;

public interface ProjectRepository extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project> {

	@Query(nativeQuery = true, value = Constants.Query.EXISTS)
	Boolean exists(@Param(Constants.Param.ID) Long id, @Param(Constants.Param.NAME) String name);

}
