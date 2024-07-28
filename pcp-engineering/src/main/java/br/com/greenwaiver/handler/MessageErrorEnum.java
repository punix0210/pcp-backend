package br.com.greenwaiver.handler;

import org.springframework.http.HttpStatus;

public enum MessageErrorEnum {

	NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Registro não encontrado"),
	OTHER(HttpStatus.BAD_REQUEST.value(), "Sitema indisponível, tente novamente mais tarde");

	private Integer code;
	private String message;

	private MessageErrorEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
