package me.blog.kei8205.lpsearch.common.mapper;

import java.util.List;

import me.blog.kei8205.lpsearch.common.annotation.DatabaseLP;
import me.blog.kei8205.lpsearch.common.model.LPLog;
import org.apache.ibatis.annotations.Param;

@DatabaseLP
public interface ItemPriceLogMapper {
	int insertItemPriceLog(
		@Param("mid") long mid
		, @Param("cid") long cid
		, @Param("lowPrice") long lowPrice
	);

	List<LPLog> selectItemPriceLogList(
		@Param("mid") long mid
		, @Param("cid") long cid
	);
}
