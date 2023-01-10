package com.cigolsoftware.cigol.enums;

public enum Reply {

	NOT("Falló la validación de un argumento."), OK(null),
	PROCESSING("Problema encontrado al procesar, analizar o generar contenido JSON."),
	SUPPORTED("El controlador de solicitudes no admite el método de solicitud específico."), THROWABLE("Error.");

	private final String message;

	Reply(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
