package me.blog.kei8205.lpsearch.common.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class BaseDatabaseConfig {
	@Autowired
	ApplicationContext applicationContext;

	protected SqlSessionFactoryBean factoryBeanSetting(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(applicationContext.getResources("classpath*:sqlmap/*.xml"));
		factoryBean.setConfigLocation(applicationContext.getResource("classpath:config/mybatis.xml"));
		factoryBean.setFailFast(true);
		return factoryBean;
	}
}
