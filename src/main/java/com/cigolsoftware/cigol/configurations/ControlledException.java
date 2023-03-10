package com.cigolsoftware.cigol.configurations;

import com.cigolsoftware.cigol.enums.Reply;

public class ControlledException extends RuntimeException {

	private static final long serialVersionUID = -7258925382603673873L;

	private final Reply reply;
	private final Boolean treatment;

	public ControlledException(final Reply reply) {
		this.reply = reply;
		this.treatment = Boolean.TRUE;
	}

	public ControlledException(final Reply reply, final Boolean treatment) {
		this.reply = reply;
		this.treatment = treatment;
	}

	public Reply getReply() {
		return this.reply;
	}

	public Boolean getTreatment() {
		return this.treatment;
	}

}
