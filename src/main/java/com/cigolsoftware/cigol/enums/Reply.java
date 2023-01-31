package com.cigolsoftware.cigol.enums;

public enum Reply {

	EXISTS(2, "Registro duplicado."), NONEXISTS(3, "Registro inexistente."),
	NOT(-1, "Contenido no admitido por el controlador de solicitudes."), OK(0, ""),
	PROCESSING(-1, "Problema encontrado al procesar, analizar o generar contenido JSON."),
	SKILL_HARD(5, "hard|debe ser mayor que o igual a 'normal'"),
	SKILL_NORMAL(4, "normal|debe ser mayor que o igual a 'easy'"),
	SUPPORTED(-1, "El controlador de solicitudes no admite el método de solicitud específico."),
	THROWABLE(-1, "Error.");

	private final Integer code;
	private final String message;

	Reply(final Integer code, final String message) {
		this.message = message;
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

}
