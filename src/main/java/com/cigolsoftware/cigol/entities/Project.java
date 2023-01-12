package com.cigolsoftware.cigol.entities;

import com.cigolsoftware.cigol.entities.dto.ProjectDto;
import com.cigolsoftware.cigol.utilities.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = Constants.PROJECTS)
public class Project extends ProjectDto {

	@Column(name = Constants.Column.ID_PRO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Override
	public Long getId() {
		return this.id;
	}

	@Column(name = Constants.Column.NAME_PRO)
	@Override
	public String getName() {
		return this.name;
	}
}
