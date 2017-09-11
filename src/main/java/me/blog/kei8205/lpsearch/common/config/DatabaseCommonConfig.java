package me.blog.kei8205.lpsearch.common.config;

import javax.sql.DataSource;

import me.blog.kei8205.lpsearch.common.annotation.DatabaseLP;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(basePackages = { "me.blog.kei8205.lpsearch" }, annotationClass = DatabaseLP.class, sqlSessionFactoryRef = "commonSqlSessionFactory")
public class DatabaseCommonConfig extends BaseDatabaseConfig {
	@Bean
	@Primary
	@Qualifier("commonDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.common")
	public DataSource commonDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	@Qualifier("commonSqlSessionFactory")
	public SqlSessionFactory commonSqlSessionFactory(@Qualifier("commonDataSource") DataSource commonDataSource) throws Exception {
		return factoryBeanSetting(commonDataSource).getObject();
	}

}
