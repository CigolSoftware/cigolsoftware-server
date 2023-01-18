package com.cigolsoftware.cigol.configurations;

import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cigolsoftware.cigol.utilities.Constants;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AspectComponent {

	@Autowired
	private Logger logger;

	@Autowired
	private HttpServletRequest request;

	@Before(Constants.Aspect.POINTCUT)
	public void before(final JoinPoint point) {
		this.request.setAttribute(Constants.Param.NAME, UUID.randomUUID().toString().split("-")[0]);
		this.logger.info(Constants.Logger.REQUEST, point.getArgs(), point.getSignature().toShortString());
	}

	@Pointcut(Constants.Aspect.ANNOTATION)
	public void pointcut() {
		// Pointcut
	}

	@AfterReturning(pointcut = Constants.Aspect.POINTCUT, returning = Constants.Aspect.ENTITY)
	public void returning(final JoinPoint point, final ResponseEntity<?> entity) {
		this.logger.info(Constants.Logger.RESPONSE, entity.getBody(), point.getSignature().toShortString());
	}
}
