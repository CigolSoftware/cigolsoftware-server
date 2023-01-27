package com.cigolsoftware.cigol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cigolsoftware.cigol.utilities.Constants;

@EnableJpaRepositories(basePackages = { Constants.Repositories.PACKAGES })
@SpringBootApplication
public class CigolApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CigolApplication.class, args);
	}

}
