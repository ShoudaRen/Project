package com.cy.myProject.mapper;


import com.cy.myProject.Mapper.MealMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MealMapperTests {

    @Autowired
    private MealMapper mealMapper;
  @Test
    public void find(){

      System.out.println(mealMapper.getMealbyName("Lamb Chops").getPrice());
  }

}
