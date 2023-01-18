package com.cigolsoftware.cigol.configurations;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cigolsoftware.cigol.enums.Reply;
import com.cigolsoftware.cigol.utilities.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class Logger {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private HttpServletRequest request;

	public void info(final String title, final Object object, final String name) {
		final var logger = LoggerFactory.getLogger(name);
		if (logger.isInfoEnabled()) {
			try {
				logger.info(Constants.Logger.FORMAT, this.request.getAttribute(Constants.Param.NAME), title,
						this.mapper.writeValueAsString(object));
			} catch (final JsonProcessingException e) {
				throw new ControlledException(Reply.PROCESSING, Boolean.FALSE);
			}
		}
	}
}