package me.blog.kei8205.lpsearch.log;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import me.blog.kei8205.lpsearch.common.helper.NaverShoppingHelper;
import me.blog.kei8205.lpsearch.common.model.InterestedItem;
import me.blog.kei8205.lpsearch.common.model.LPLog;
import me.blog.kei8205.lpsearch.item.InterestedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ItemPriceLogService {

	@Autowired
	private InterestedItemService interestedItemService;
	@Autowired
	private ItemPriceLogRepository itemPriceLogRepository;

	public List<LPLog> getPriceLogList(long cid, long mid){
		return itemPriceLogRepository.selectItemPriceLogList(mid, cid);
	}

	public void logInterestedItem() {
		List<InterestedItem> allInterestedItemList = interestedItemService.getAllInterestedItemList();
		if (allInterestedItemList != null) {
			for (InterestedItem oldItem : allInterestedItemList) {
				try {
					InterestedItem updatedItem = NaverShoppingHelper.naverShoppingUrlCheck(NaverShoppingHelper.generateNaverShoppingDetailUrl(oldItem.getMid(), oldItem.getCid()));
					insertPriceLog(updatedItem);
					if (updatedItem.getInitialLowPrice() < oldItem.getInitialLowPrice()) {
						interestedItemService.updateLegendaryLowPrice(updatedItem);
					}
					Thread.sleep(800);
				} catch (Exception e) {
					log.error("## ItemPriceLogService.logInterestedItem ## {}", e.getMessage(), e);
				}
			}
		}
	}

	private void insertPriceLog(InterestedItem newInterestedItem) {
		itemPriceLogRepository.insertItemPriceLog(newInterestedItem);
	}


}
