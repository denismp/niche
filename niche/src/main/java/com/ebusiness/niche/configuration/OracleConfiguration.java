package com.ebusiness.niche.configuration;

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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories( entityManagerFactoryRef = "entityManagerFactory", basePackages = { "com.example.demo.dao" })
public class OracleConfiguration implements WebMvcConfigurer {
	
//	@Primary
	@Bean(name = "dataSource" )
	@ConfigurationProperties(prefix="spring.oracle.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();		
	}
	
	public LocalContainerEntityManagerFactoryBean entityManagerFactory( 
			EntityManagerFactoryBuilder builder, 
			@Qualifier("dataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("com.example.demo.entity")
				.persistenceUnit("DEMO_P_UNIT").build();		
	}

//	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
		
	}

//	@Primary
//	@Bean(name = "sessionFactory")
//	public HibernateJpaSessionFactoryBean sessionFactory() {
//		return new HibernateJpaSessionFactoryBean();
//		
//	}

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}

