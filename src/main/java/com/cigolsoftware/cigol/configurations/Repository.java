package com.cigolsoftware.cigol.configurations;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository<D> extends JpaRepository<D, Long> {

	Boolean exists(Long id, String name);
}
