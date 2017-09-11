package me.blog.kei8205.lpsearch.common.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PriceHistoryData {
	private List<String> labels;
	private List<Long> priceHistoryDatas;
}
