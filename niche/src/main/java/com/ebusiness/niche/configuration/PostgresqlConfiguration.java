package com.ebusiness.niche.configuration;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.example.demo.entity.Book;  //TODO need to include the entities.

//import com.roufid.tutorial.entity.postgresql.Book;

/**
 * Spring configuration of the "PostgreSQL" database.
 * 
 * @author Radouane ROUFID.
 *
 */
@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories(
//		entityManagerFactoryRef = "postgresqlEntityManager", 
//		transactionManagerRef = "postgresqlTransactionManager", 
////		basePackages = "com.roufid.tutorial.dao.postgresql"
//		basePackages = "com.example.dao"
//)
@EnableJpaRepositories(
		entityManagerFactoryRef = "transactionManager", 
		transactionManagerRef = "postgresqlTransactionManager", 
		basePackages = {
		"com.ebusiness.niche.dao" })
public class PostgresqlConfiguration {

	/**
	 * PostgreSQL datasource definition.
	 * 
	 * @return datasource.
	 */
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.postgresql.datasource")
	public DataSource postgresqlDataSource() {
		return DataSourceBuilder
					.create()
					.build();
	}

	/**
	 * Entity manager definition. 
	 *  
	 * @param builder an EntityManagerFactoryBuilder.
	 * @return LocalContainerEntityManagerFactoryBean.
	 */
//	@Primary
//	@Bean(name = "postgresqlEntityManager")
//	public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//		return builder
//					.dataSource(postgresqlDataSource())
//					.properties(hibernateProperties())
////					.packages(Book.class)  //TODO need to add this back for the entities.
//					.persistenceUnit("postgresqlPU")
//					.build();
//	}
	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(postgresqlDataSource()).properties(hibernateProperties())
				.packages("com.ebusiness.niche.entity").persistenceUnit("postgresqlPU").build();
	}

//	@Primary
//	@Bean(name = "postgresqlTransactionManager")
//	public PlatformTransactionManager postgresqlTransactionManager(@Qualifier("transactionManager") EntityManagerFactory entityManagerFactory) {
//		return new JpaTransactionManager(entityManagerFactory);
//	}
	/**
	 * @param entityManagerFactory
	 * @return
	 */
	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	private Map<String, Object> hibernateProperties() {

		Resource resource = new ClassPathResource("hibernate.properties");
		
		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			return properties.entrySet().stream()
											.collect(Collectors.toMap(
														e -> e.getKey().toString(),
														e -> e.getValue())
													);
		} catch (IOException e) {
			return new HashMap<String, Object>();
		}
	}
}
