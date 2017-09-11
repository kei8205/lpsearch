package me.blog.kei8205.lpsearch.user;

import me.blog.kei8205.lpsearch.common.mapper.UserMapper;
import me.blog.kei8205.lpsearch.common.model.LPUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	@Autowired
	private UserMapper userMapper;

	public void insertUser(LPUser userToInsert) {
		userMapper.insertUser(userToInsert);
	}

	public LPUser selectUser(String accessToken) {
		return userMapper.selectUser(accessToken);
	}
}
