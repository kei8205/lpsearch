package me.blog.kei8205.lpsearch.common.model.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddInterestItemParam {
	private int userSeq;
	private long mid;
	private long cid;
	private String title;
	private String thumbUrl;
	private int initialLowPrice;
}
