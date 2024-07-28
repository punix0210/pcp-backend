package br.com.greenwaiver.response;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DataResponse {

	private String statusCode;
	private LocalDateTime timestamp;
	@JsonInclude(value = Include.NON_NULL)	
	private String message;
	@JsonInclude(value = Include.NON_NULL)
	private Map<String, Object> data;
	@JsonInclude(value = Include.NON_NULL)
	private Map<String, Object> error;
	
	private DataResponse(DataResponseBuilder builder) {
		this.statusCode = builder.statusCode;
		this.error = builder.error;
		this.data = builder.data;
		this.message = builder.message;
		this.timestamp = builder.timestamp;
	} 

	public String getStatusCode() {
		return statusCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public Map<String, Object> getError() {
		return error;
	}

	public static class DataResponseBuilder {
		private String statusCode;
		private LocalDateTime timestamp;
		private String message;
		private Map<String, Object> data;
		private Map<String, Object> error;

		public DataResponseBuilder setStatusCode(String statusCode) {
			this.statusCode = statusCode;
			return this;
		}

		public DataResponseBuilder setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public DataResponseBuilder setMessage(String message) {
			this.message = message;
			return this;
		}

		public DataResponseBuilder setData(Map<String, Object> data) {
			this.data = data;
			return this;
		}

		public DataResponseBuilder setError(Map<String, Object> error) {
			this.error = error;
			return this;
		}

		public DataResponse build() {
			return new DataResponse(this);
		}		
	}
}