package me.blog.kei8205.lpsearch.user;

import lombok.extern.slf4j.Slf4j;
import me.blog.kei8205.lpsearch.common.model.LPUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void insertUser(LPUser userToInsert) {
		userRepository.insertUser(userToInsert);
	}

	public LPUser getUser(String accessToken) {
		return userRepository.selectUser(accessToken);
	}

}
