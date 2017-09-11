package me.blog.kei8205.lpsearch.common.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LPLog {
	private long mid;
	private long cid;
	private long lp;
	private Date logDatetime;
}
