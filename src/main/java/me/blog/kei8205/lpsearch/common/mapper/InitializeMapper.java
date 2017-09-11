package me.blog.kei8205.lpsearch.common.mapper;

import java.util.List;

import me.blog.kei8205.lpsearch.common.annotation.DatabaseLP;

@DatabaseLP
public interface InitializeMapper {
	List<String> showTables();
	int createUserTable();
	int createInterrestedItemTable();
	int createItemLogTable();
}
