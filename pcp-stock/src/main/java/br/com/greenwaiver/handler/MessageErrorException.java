package br.com.greenwaiver.handler;

public class MessageErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private Integer code;
	private String message;

	public MessageErrorException(MessageErrorEnum error) {
		super(error.getMessage());
		this.code = error.getCode();
		this.message = error.getMessage();
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
