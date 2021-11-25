package com.cy.myProject.mapper;



import com.cy.myProject.Mapper.TickMapper;
import com.cy.myProject.entity.Flight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootTest // 表示标注当前的类是一个测试类，不会随同项目一款打包
@RunWith(SpringRunner.class)//表示启动这个单元测试类（没有这个注解无法运行）需要传递一个参数必须是SpringRunner

public class TicketMapperTests {

    @Autowired
    private TickMapper tickMapper;

    @Test
    public void findpartticket() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date javaDate = sdf.parse("2021-11-06");

        java.sql.Date date = new java.sql.Date(javaDate.getTime());

      List<Flight> a =  tickMapper.findTick("Beijing","Shanghai",date);
        System.out.println(a);

    }

    @Test
    public void findAllticket(){
        List<Flight> b=  tickMapper.findAllTicket();
        System.out.println(b);
    }


    @Test
    public void findTicketbYfLID(){
        Flight flight =  tickMapper.bookAFlightbyflightId(3);
        System.out.println(flight);
    }

    @Test
    public void updateFlightNumByflghtId(){
        tickMapper.updateFlightNumByflghtId(3,249);
    }


    @Test
    public void findSale(){
        List<Flight> b= tickMapper.findOnsale();
        System.out.println(b);
    }
}
