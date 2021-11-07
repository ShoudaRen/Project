package com.cy.myProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//在项目启动时加载所有接口文件
@MapperScan("com.cy.myProject.Mapper")
public class MyProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyProjectApplication.class, args);
	}

}
