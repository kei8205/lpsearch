package me.blog.kei8205.lpsearch.common.exception;

import lombok.extern.slf4j.Slf4j;
import me.blog.kei8205.lpsearch.common.type.ErrorType;

@Slf4j
public class BaseRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -2933254305654995912L;

	private ErrorType errorType;

	public BaseRuntimeException(ErrorType errorType, String message) {
		super(message);
		this.errorType = errorType;
	}

	public BaseRuntimeException(ErrorType errorType, Throwable cause) {
		super(cause);
		this.errorType = errorType;
	}

	public BaseRuntimeException(ErrorType errorType, String message, Throwable cause) {
		super(message, cause);
		this.errorType = errorType;
	}

	public ErrorType getErrorType() {
		return errorType;
	}
}
