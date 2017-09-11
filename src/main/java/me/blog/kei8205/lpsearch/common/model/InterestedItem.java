package me.blog.kei8205.lpsearch.common.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InterestedItem {
	private int userSeq;
	private long mid;
	private long cid;
	private String title;
	private String thumbUrl;
	private long initialLowPrice;
	private boolean active;
	private Date registerDatetime;

	private long legendaryPrice;
	private Date legendaryPriceDatetime;
}
