package me.blog.kei8205.lpsearch.initialize;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import me.blog.kei8205.lpsearch.common.constant.LPConstant;
import me.blog.kei8205.lpsearch.common.model.LPUser;
import me.blog.kei8205.lpsearch.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InitializeService {
	@Autowired
	private InitializeRepository initializeRepository;
	@Autowired
	private UserService userService;

	public boolean isInitialized() {
		List<String> tableNames = initializeRepository.showTables();
		if (tableNames == null || tableNames.isEmpty()) {
			log.warn("## InitializeService.isInitialized ## no tables");
			return false;
		}
		for (String tableName : tableNames) {
			log.debug("## InitializeService.isInitialized ## {} exist", tableName);
		}
		return true;
	}

	public void initializeTables() {
		log.debug("## InitializeService.initializeTables ## user table create");
		initializeRepository.createUserTable();
		log.debug("## InitializeService.initializeTables ## item table create");
		initializeRepository.createItemTable();
		log.debug("## InitializeService.initializeTables ## log table create");
		initializeRepository.createLogTable();

		log.debug("## InitializeService.initializeTables ## insert guest user");
		userService.insertUser(LPUser.builder().accessToken(LPConstant.ACCESSTOKEN_FOR_GUEST_USER).build());
	}
}
