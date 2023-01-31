package com.cigolsoftware.cigol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Filter {

	@Min(0)
	@NotNull
	private Integer page;
	private Integer size;
	private String value;

	public Integer getPage() {
		return this.page;
	}

	public Integer getSize() {
		return this.size;
	}

	public String getValue() {
		return this.value;
	}

	public void setPage(final Integer page) {
		this.page = page;
	}

	public void setSize(final Integer size) {
		this.size = size;
	}

	public void setValue(final String value) {
		this.value = value;
	}

}
