package me.blog.kei8205.lpsearch.common.mapper;

import me.blog.kei8205.lpsearch.common.annotation.DatabaseLP;
import me.blog.kei8205.lpsearch.common.model.LPUser;
import org.apache.ibatis.annotations.Param;

@DatabaseLP
public interface UserMapper {
	int insertUser(LPUser userToInsert);

	LPUser selectUser(@Param("accessToken") String accessToken);
}
