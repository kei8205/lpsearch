package me.blog.kei8205.lpsearch.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;
import org.springframework.validation.BindingResult;

@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LPBaseResponse {
	public final static int SUCCESS = 0;
	public final static int FAIL = 500;

	@JsonProperty("code")
	int code = SUCCESS;
	@JsonProperty("message")
	String message = "success";
	@JsonProperty("result")
	Object result;

	public static LPBaseResponse success() {
		return LPBaseResponse.builder().code(SUCCESS).build();
	}

	public static LPBaseResponse successMessage(String message) {
		return LPBaseResponse.builder().code(SUCCESS).message(message).build();
	}

	public static LPBaseResponse successResult(Object result) {
		return LPBaseResponse.builder().code(SUCCESS).result(result).build();
	}

	public static LPBaseResponse successMessageResult(String message, Object result) {
		return LPBaseResponse.builder().code(SUCCESS).message(message).result(result).build();
	}

	public static LPBaseResponse errorResult(String message) {
		return LPBaseResponse.builder().code(FAIL).message(message).build();
	}

	public static LPBaseResponse errorResult(BindingResult result) {
		return errorResult(result.toString());
	}
}
