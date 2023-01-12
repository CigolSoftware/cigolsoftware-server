package com.cigolsoftware.cigol.dto;

import org.springframework.http.ResponseEntity;

import com.cigolsoftware.cigol.enums.Reply;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Body<R> {

	public static Body<Void> body(final Reply reply) {
		return new Body<>(reply.getCode(), reply.getMessage(), null);
	}

	public static <R> ResponseEntity<Body<R>> ok(final R response) {
		return Body.ok(Reply.OK, response);
	}

	public static <R> ResponseEntity<Body<R>> ok(final Reply reply) {
		return Body.ok(reply, null);
	}

	private static <R> ResponseEntity<Body<R>> ok(final Reply reply, final R response) {
		return ResponseEntity.ok(new Body<>(reply.getCode(), reply.getMessage(), response));
	}

	private final Integer code;
	private final String message;
	private final R response;

	private Body(final Integer code, final String message, final R response) {
		this.code = code;
		this.message = message;
		this.response = response;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

	public R getResponse() {
		return this.response;
	}

}
