package com.cigolsoftware.cigol.entities.dto;

import com.cigolsoftware.cigol.entities.Project;
import com.cigolsoftware.cigol.utilities.Tools;

public class ProjectDto extends Dto<Project> {

	@Override
	public Project dao() {
		return Tools.copyProperties(this, new Project());
	}

}
