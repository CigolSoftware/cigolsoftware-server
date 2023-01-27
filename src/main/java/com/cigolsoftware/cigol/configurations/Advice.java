package com.cigolsoftware.cigol.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cigolsoftware.cigol.dto.Body;
import com.cigolsoftware.cigol.enums.Reply;

@ControllerAdvice
public class Advice {

	@Autowired
	private Logger logger;

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Body<Void>> accessException(final EmptyResultDataAccessException exception) {
		this.info(exception, Reply.NONEXISTS);
		return Body.badRequest(Reply.NONEXISTS);
	}

	@ExceptionHandler(ControlledException.class)
	public ResponseEntity<Body<Void>> controlledException(final ControlledException exception) {
		this.info(exception, exception.getReply());
		return Boolean.TRUE.equals(exception.getTreatment()) ? Body.ok(exception.getReply())
				: Body.badRequest(exception.getReply());
	}

	@ExceptionHandler({ HttpMediaTypeNotSupportedException.class, HttpMessageNotReadableException.class,
			MethodArgumentNotValidException.class })
	public ResponseEntity<Body<Void>> exception(final Exception exception) {
		this.info(exception, Reply.NOT);
		return Body.badRequest(Reply.NOT);
	}

	private void info(final Exception exception, final Reply reply) {
		this.logger.info(exception.getClass().toString(), reply.getMessage());
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Body<Void>> supportedException(final HttpRequestMethodNotSupportedException exception) {
		this.info(exception, Reply.SUPPORTED);
		return Body.badRequest(Reply.SUPPORTED);
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Body<Void>> throwable(final Throwable throwable) {
		this.logger.info(throwable.getClass().toString(), throwable.getLocalizedMessage());
		return ResponseEntity.internalServerError().body(Body.body(Reply.THROWABLE));
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Body<Void>> violationException(final Exception exception) {
		this.info(exception, Reply.EXISTS);
		return Body.badRequest(Reply.EXISTS);
	}

}
