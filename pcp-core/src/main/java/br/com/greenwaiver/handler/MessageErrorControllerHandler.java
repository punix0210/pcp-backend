package br.com.greenwaiver.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.greenwaiver.response.DataResponse;
import br.com.greenwaiver.response.DataResponse.DataResponseBuilder;

@RestControllerAdvice
public class MessageErrorControllerHandler {
	Logger log = LoggerFactory.getLogger(MessageErrorControllerHandler.class);

	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<?> handleGenericRunTimeException(RuntimeException ex) {

		if (ex instanceof MessageErrorException) {
			MessageErrorException error = (MessageErrorException) ex;

			return new ResponseEntity<>(getErrorMessage(error.getMessage(), error.getCode(), ex),
					HttpStatus.valueOf(error.getCode()));
		}

		return new ResponseEntity<>(
				getErrorMessage(MessageErrorEnum.OTHER.getMessage(), MessageErrorEnum.OTHER.getCode(), ex),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<?> handleGenericException(Exception ex) {

		if (ex instanceof MessageErrorException) {
			MessageErrorException error = (MessageErrorException) ex;

			return new ResponseEntity<>(getErrorMessage(error.getMessage(), error.getCode(), ex),
					HttpStatus.valueOf(error.getCode()));
		}

		return new ResponseEntity<>(
				getErrorMessage(MessageErrorEnum.OTHER.getMessage(), MessageErrorEnum.OTHER.getCode(), ex),
				HttpStatus.BAD_REQUEST);
	}	
	
	@ExceptionHandler(value = { MethodArgumentNotValidException .class })
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException  ex) {

		return new ResponseEntity<>(
				getErrorMessage(MessageErrorEnum.OTHER.getMessage(), MessageErrorEnum.OTHER.getCode(), ex),
				HttpStatus.BAD_REQUEST);
	}	

	private DataResponse getErrorMessage(String message, Integer code, Exception ex) {
		Map<String, Object> error = new HashMap<>();
		error.put("message", message);
		error.put("detail", ex.getCause());
				
		log.info("Mensagem de erro ::  {} - causa :: {} - StackTrace :: ", error, ex.getCause(), ex.getStackTrace());

		DataResponse dataResponse = new DataResponseBuilder()
				.setData(null)
				.setError(error)
				.setMessage(ex.getMessage())
				.setStatusCode(String.valueOf(code))
				.setTimestamp(LocalDateTime.now()).build();
		
		return dataResponse;
	}
}
