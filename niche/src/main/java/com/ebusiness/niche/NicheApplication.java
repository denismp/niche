package com.ebusiness.niche;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class NicheApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(NicheApplication.class, args);
//	}
//}

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.ebusiness.niche")
@SpringBootApplication
@EntityScan("com.ebusiness.niche.entity")
@EnableJpaRepositories("com.ebusiness.niche.dao")
public class NicheApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

	public static void main(String[] args) {
		SpringApplication.run(NicheApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure( SpringApplicationBuilder application ) {
		return application.sources(applicationClass );
	}
	
	private static Class<NicheApplication> applicationClass = NicheApplication.class;
}
