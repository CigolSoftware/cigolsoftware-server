package com.cigolsoftware.cigol.entities.dto;

public class SkillDto extends Dto {

	protected Integer easy;
	protected Integer hard;
	protected Integer normal;

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
