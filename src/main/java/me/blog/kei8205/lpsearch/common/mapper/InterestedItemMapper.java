package me.blog.kei8205.lpsearch.common.mapper;

import java.util.List;

import me.blog.kei8205.lpsearch.common.annotation.DatabaseLP;
import me.blog.kei8205.lpsearch.common.model.InterestedItem;
import org.apache.ibatis.annotations.Param;

@DatabaseLP
public interface InterestedItemMapper {
	List<InterestedItem> selectInterestedItemList(@Param("userSeq") int userSeq);
	List<InterestedItem> selectAllInterestedItemList();
	InterestedItem selectInterestedItem(
		@Param("userSeq") int userSeq
		, @Param("mid") long mid
		, @Param("cid") long cid
	);
	int insertInterestedItem(
	@Param("userSeq") int userSeq
		, @Param("mid") long mid
		, @Param("cid") long cid
		, @Param("title") String title
		, @Param("thumbUrl") String thumbUrl
		, @Param("initialLowPrice") long initialLowPrice
	);

	void updateLegendaryLowPrice(
		@Param("mid") long mid
		, @Param("cid") long cid
		,@Param("lowPrice") long lowPrice
	);
}
