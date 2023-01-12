package com.cigolsoftware.cigol.enums;

public enum Reply {

	EXISTS(1, "Registro duplicado."), NOT(-1, "Falló la validación de un argumento."), OK(0, ""),
	PROCESSING(-1, "Problema encontrado al procesar, analizar o generar contenido JSON."),
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
