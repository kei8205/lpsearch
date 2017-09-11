package me.blog.kei8205.lpsearch.common.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LPUser {
	private int seq;
	private String accessToken;
	private String pushToken;
	private Date registerDatetime;
}
