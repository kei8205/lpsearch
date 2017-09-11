package me.blog.kei8205.lpsearch.item;

import java.util.List;

import me.blog.kei8205.lpsearch.common.mapper.InterestedItemMapper;
import me.blog.kei8205.lpsearch.common.model.InterestedItem;
import me.blog.kei8205.lpsearch.common.model.param.AddInterestItemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository class InterestedItemRepository {
	@Autowired
	private InterestedItemMapper interestedItemMapper;

	public List<InterestedItem> selectInterestedItemList(int userSeq) {
		return interestedItemMapper.selectInterestedItemList(userSeq);
	}

	public InterestedItem selectInterestedItem(int userSeq, long mid, long cid) {
		return interestedItemMapper.selectInterestedItem(userSeq, mid, cid);
	}

	public boolean insertInterestedItem(AddInterestItemParam param) {
		return 0 < interestedItemMapper.insertInterestedItem(
			param.getUserSeq()
			, param.getMid()
			, param.getCid()
			, param.getTitle()
			, param.getThumbUrl()
			, param.getInitialLowPrice()
		);
	}

	public List<InterestedItem> selectAllInterestedItemList() {
		return interestedItemMapper.selectAllInterestedItemList();
	}

	public void updateLegendaryLowPrice(InterestedItem item){

	}
}
