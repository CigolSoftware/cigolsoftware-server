package com.cigolsoftware.cigol.entities;

import java.time.LocalDateTime;

import com.cigolsoftware.cigol.entities.dto.SkillDto;
import com.cigolsoftware.cigol.utilities.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity(name = Constants.Mapping.SKILLS)
public class Skill extends SkillDto {

	@Column(name = Constants.Column.EASY_SKI)
	@Override
	public Integer getEasy() {
		return this.easy;
	}

	@Column(name = Constants.Column.HARD_SKI)
	@Override
	public Integer getHard() {
		return this.hard;
	}

	@Column(name = Constants.Column.ID_SKI)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Override
	public Long getId() {
		return this.id;
	}

	@Column(name = Constants.Column.MODIFICATION_SKI)
	@Override
	public LocalDateTime getModification() {
		return this.modification;
	}

	@Column(name = Constants.Column.NAME_SKI)
	@Override
	public String getName() {
		return this.name;
	}

	@Column(name = Constants.Column.NORMAL_SKI)
	@Override
	public Integer getNormal() {
		return this.easy;
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
