package me.blog.kei8205.lpsearch.common.type;

import lombok.Getter;

@Getter
public enum ErrorType {
	INVALID_PARAMETER(430, "error.invalid.parameter"), // 잘못된 인자
	SERVER_INTERNAL(500, "error.server.general"),
	UNKNOWN(999, "error.unknown");

	int code;
	String messageResourceId;

	ErrorType(int code, String messageCode) {
		this.code = code;
		this.messageResourceId = messageCode;
	}

	public static ErrorType of(int code) {
		for (ErrorType type : values()) {
			if (type.getCode() == code) {
				return type;
			}
		}

		return UNKNOWN;
	}
}
