package com.cy.myProject.mapper;


import com.cy.myProject.Mapper.PickUpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PickUpMapperTests {

    @Autowired
    private PickUpMapper pickUpMapper;
  @Test
    public void find(){
      System.out.println( pickUpMapper.getcarByname("Maserati").getPrice());
  }

}
