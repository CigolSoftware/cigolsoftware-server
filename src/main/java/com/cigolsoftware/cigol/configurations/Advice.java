package com.cigolsoftware.cigol.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cigolsoftware.cigol.dto.Body;
import com.cigolsoftware.cigol.enums.Reply;
import com.cigolsoftware.cigol.utilities.Constants;
import com.cigolsoftware.cigol.utilities.Tools;

@ControllerAdvice
public class Advice {

	@Autowired
	private Logger logger;

	@ExceptionHandler(ControlledException.class)
	public ResponseEntity<Body<Void>> controlled(final ControlledException exception) {
		this.info(exception.getReply(), exception);
		return Boolean.TRUE.equals(exception.getTreatment()) ? Body.ok(exception.getReply())
				: Tools.badRequest(exception.getReply());
	}

	private void info(final Reply reply, final Exception exception) {
		this.logger.info(reply.name(), reply.getMessage(), exception.getClass().getName());
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class, MethodArgumentNotValidException.class })
	public ResponseEntity<Body<Void>> not(final Exception exception) {
		this.info(Reply.NOT, exception);
		return Tools.badRequest(Reply.NOT);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Body<Void>> supported(final HttpRequestMethodNotSupportedException exception) {
		this.info(Reply.SUPPORTED, exception);
		return Tools.badRequest(Reply.SUPPORTED);
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Body<Void>> throwable(final Throwable throwable) {
		this.logger.info(Constants.Logger.ERROR, throwable.getLocalizedMessage(), throwable.getClass().getName());
		return ResponseEntity.internalServerError().body(Body.body(Reply.THROWABLE));
	}

}
