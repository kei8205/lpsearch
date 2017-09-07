package me.blog.kei8205.lpsearch.common.config;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import me.blog.kei8205.lpsearch.common.exception.BaseRuntimeException;
import me.blog.kei8205.lpsearch.common.model.LPBaseResponse;
import me.blog.kei8205.lpsearch.common.type.ErrorType;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public LPBaseResponse defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
			throw e;
		}

		if (e instanceof BaseRuntimeException) {
			BaseRuntimeException bre = (BaseRuntimeException) e;
			return LPBaseResponse.builder().code(bre.getErrorType().getCode()).message(bre.getLocalizedMessage()).build();
		} else {
			log.error("Internal system error", e);
		}

		// TODO: message i18n 처리 필요.
		return LPBaseResponse.builder().code(ErrorType.SERVER_INTERNAL.getCode()).message("general exception").build();
	}

	@ExceptionHandler(value = { MissingServletRequestParameterException.class, MethodArgumentNotValidException.class })
	@ResponseBody
	public LPBaseResponse missingParameterErrorHandler(HttpServletRequest request, Exception e) {
		return LPBaseResponse.builder().code(ErrorType.INVALID_PARAMETER.getCode()).message(e.getMessage()).build();

	}
}
