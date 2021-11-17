package com.cy.myProject.service;



import com.cy.myProject.entity.Passenger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest // 表示标注当前的类是一个测试类，不会随同项目一款打包
@RunWith(SpringRunner.class)//表示启动这个单元测试类（没有这个注解无法运行）需要传递一个参数必须是SpringRunner

public class PassengerServiceTests {
    @Autowired
    private IPassengerService iPassengerService;


    @Test
    public void testPassengerInsert(){
        Passenger passenger1 = new Passenger();
        passenger1.setUid(6);
        passenger1.setEmail("3434@qq.com");
        passenger1.setFirstname("sam");
        passenger1.setLastname("alice");passenger1.setPassport("FG123");
        iPassengerService.insertPassenger(passenger1,6,"test");
    }
   }



