package me.blog.kei8205.lpsearch.log;

import java.util.List;

import me.blog.kei8205.lpsearch.common.mapper.ItemPriceLogMapper;
import me.blog.kei8205.lpsearch.common.model.InterestedItem;
import me.blog.kei8205.lpsearch.common.model.LPLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemPriceLogRepository {
	@Autowired
	private ItemPriceLogMapper itemPriceLogMapper;

	public boolean insertItemPriceLog(InterestedItem item) {
		return 0 < itemPriceLogMapper.insertItemPriceLog(
			item.getMid()
			, item.getCid()
			, item.getInitialLowPrice()
		);
	}

	public List<LPLog> selectItemPriceLogList(long mid, long cid) {
		return itemPriceLogMapper.selectItemPriceLogList(mid, cid);
	}
}
