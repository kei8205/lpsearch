package me.blog.kei8205.lpsearch.initialize;

import java.util.List;

import me.blog.kei8205.lpsearch.common.mapper.InitializeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
class InitializeRepository {
	@Autowired
	private InitializeMapper initializeMapper;

	public List<String> showTables() {
		return initializeMapper.showTables();
	}

	public void createUserTable() {
		initializeMapper.createUserTable();
	}

	public void createItemTable() {
		initializeMapper.createInterrestedItemTable();
	}

	public void createLogTable() {
		initializeMapper.createItemLogTable();
	}
}
