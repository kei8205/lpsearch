package me.blog.kei8205.lpsearch.item;

import java.util.ArrayList;
import java.util.List;

import me.blog.kei8205.lpsearch.common.model.InterestedItem;
import me.blog.kei8205.lpsearch.common.model.LPUser;
import me.blog.kei8205.lpsearch.common.model.param.AddInterestItemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestedItemService {
	@Autowired
	private InterestedItemRepository interestedItemRepository;

	public List<InterestedItem> getInterestedItemList(LPUser lpUser) {
		if (lpUser == null) {
			return new ArrayList<>();
		}
		return interestedItemRepository.selectInterestedItemList(lpUser.getSeq());
	}

	public List<InterestedItem> getAllInterestedItemList(){
		return interestedItemRepository.selectAllInterestedItemList();
	}

	public InterestedItem getInterestedItem(int userSeq, long mid, long cid) {
		return interestedItemRepository.selectInterestedItem(userSeq, mid, cid);
	}

	public boolean insertInterestedItem(AddInterestItemParam param) {
		return interestedItemRepository.insertInterestedItem(param);
	}

	public void updateLegendaryLowPrice(InterestedItem item){

	}
}
