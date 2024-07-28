package br.com.greenwaiver.handler;

public enum MessageErrorEnum {

	NOT_FOUND(404, "Registro não encontrado"), OTHER(500, "Sitema indisponível, tente novamente mais tarde");

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
