package com.cigolsoftware.cigol.entities;

import com.cigolsoftware.cigol.entities.dto.Dto;

public interface Dao<D extends Dto<?>> {

	D dto();
}
