package com.cigolsoftware.cigol.entities.dto;

import com.cigolsoftware.cigol.entities.Skill;
import com.cigolsoftware.cigol.utilities.Tools;

import jakarta.validation.constraints.Min;

public class SkillDto extends Dto<Skill> {

	@Min(0)
	protected Integer easy;

	protected Integer hard;
	protected Integer normal;

	@Override
	public Skill dao() {
		return Tools.copyProperties(this, new Skill());
	}

	public Integer getEasy() {
		return this.easy;
	}

	public Integer getHard() {
		return this.hard;
	}

	public Integer getNormal() {
		return this.normal;
	}

	public void setEasy(final Integer easy) {
		this.easy = easy;
	}

	public void setHard(final Integer hard) {
		this.hard = hard;
	}

	public void setNormal(final Integer normal) {
		this.normal = normal;
	}

}
