package com.cy.myProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class MyProjectApplicationTests {
	@Autowired //Automatic configuration
  private DataSource dataSource;
	@Test
	void contextLoads() {
	}

	//TEST DATABASE
	@Test
	void  getConnection() throws SQLException {
		System.out.println(dataSource.getConnection());
	}



}
