package com.cigolsoftware.cigol.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cigolsoftware.cigol.configurations.Repository;
import com.cigolsoftware.cigol.entities.Dao;
import com.cigolsoftware.cigol.entities.dto.Dto;

public class DaoService<A extends Dao<T>, R extends Repository<A>, T extends Dto<A>> {

	@Autowired
	protected R repository;

	public Boolean exists(final T dto) {
		return this.repository.exists(dto.getId(), dto.getName());
	}

	public T save(final T dto) {
		return this.repository.save(dto.dao()).dto();
	}

}
