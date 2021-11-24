package com.cy.myProject.mapper;


import com.cy.myProject.Mapper.luggageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class LuggageMapperTests {

    @Autowired
    private luggageMapper luggageMapper;
  @Test
    public void find(){

      System.out.println(luggageMapper.getLuaByName("10KG").getPrice());
  }

}
