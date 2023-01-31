package com.cigolsoftware.cigol.entities;

import java.time.LocalDateTime;

import com.cigolsoftware.cigol.entities.dto.ProjectDto;
import com.cigolsoftware.cigol.utilities.Constants;
import com.cigolsoftware.cigol.utilities.Tools;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity(name = Constants.Mapping.PROJECTS)
public class Project extends ProjectDto implements Dao<ProjectDto> {

	@Override
	public ProjectDto dto() {
		return Tools.copyProperties(this, new ProjectDto());
	}

	@Column(name = Constants.Column.ID_PRO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Override
	public Long getId() {
		return this.id;
	}

	@Column(name = Constants.Column.MODIFICATION_PRO)
	@Override
	public LocalDateTime getModification() {
		return this.modification;
	}

	@Column(name = Constants.Column.NAME_PRO)
	@Override
	public String getName() {
		return this.name;
	}

	@PrePersist
	private void prePersist() {
		this.modification = LocalDateTime.now();
	}

	@PreUpdate
	private void preUpdate() {
		this.modification = LocalDateTime.now();
	}

}
