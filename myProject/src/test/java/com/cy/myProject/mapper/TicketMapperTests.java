package com.cy.myProject.mapper;



import com.cy.myProject.Mapper.TickMapper;
import com.cy.myProject.Mapper.passengerMapper;
import com.cy.myProject.entity.Passenger;
import com.cy.myProject.entity.TicketSearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest // 表示标注当前的类是一个测试类，不会随同项目一款打包
@RunWith(SpringRunner.class)//表示启动这个单元测试类（没有这个注解无法运行）需要传递一个参数必须是SpringRunner

public class TicketMapperTests {

    @Autowired
    private TickMapper tickMapper;

    @Test
    public void findpartticket(){

      List<TicketSearch> a =  tickMapper.findTick("11/22/12","LONDON","PARIS",10,10,10,10,"economy");
        System.out.println(a);

    }

    @Test
    public void findAllticket(){
        List<TicketSearch> b=  tickMapper.findAllTicket();
        System.out.println(b);
    }
}
