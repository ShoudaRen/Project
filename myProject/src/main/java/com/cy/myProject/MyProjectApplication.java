package com.cy.myProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;
import java.util.Date;

@Configuration //Load all configuration classes
@SpringBootApplication
//Load all interface files at project startup
@MapperScan("com.cy.myProject.Mapper")
public class MyProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}
   @Bean
	public MultipartConfigElement getMultipartConfigElement(){
	   // Create a configured factory class
	   MultipartConfigFactory factory = new MultipartConfigFactory();
	   // Set the information about the object to be created
	   factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
	   factory.setMaxRequestSize(DataSize.of(15, DataUnit.MEGABYTES));
	   // Use the factory class to create the MultipartConfigElement object
	   return factory.createMultipartConfig();

	}
}
