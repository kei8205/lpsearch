package me.blog.kei8205.lpsearch.common.helper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.blog.kei8205.lpsearch.common.model.LPLog;
import me.blog.kei8205.lpsearch.common.model.PriceHistoryData;

public class PriceHistoryChartHelper {

	public static PriceHistoryData generateStatisticsChartData(List<LPLog> logList) {
		Collections.reverse(logList);
		List<String> labels = new ArrayList<>();
		List<Long> priceHistoryDatas = new ArrayList<>();
		SimpleDateFormat sdf_mmdd_HHmm = new SimpleDateFormat("MM/dd HH:mm");
		for (LPLog stat : logList) {
			labels.add(sdf_mmdd_HHmm.format(stat.getLogDatetime()));
			priceHistoryDatas.add(stat.getLp());
		}

		return PriceHistoryData
			.builder()
			.labels(labels)
			.priceHistoryDatas(priceHistoryDatas)
			.build();
	}
}
