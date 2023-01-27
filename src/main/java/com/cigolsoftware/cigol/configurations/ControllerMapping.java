package com.cigolsoftware.cigol.configurations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RequestMapping
@RestController
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerMapping {
	@AliasFor(annotation = RequestMapping.class)
	public String value();
}
