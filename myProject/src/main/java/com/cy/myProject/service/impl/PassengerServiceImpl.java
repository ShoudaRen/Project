package com.cy.myProject.service.impl;

import com.cy.myProject.Mapper.passengerMapper;
import com.cy.myProject.entity.Passenger;
import com.cy.myProject.service.IPassengerService;
import com.cy.myProject.service.ex.InsertCountLimitedException;
import com.cy.myProject.service.ex.updateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PassengerServiceImpl implements IPassengerService {
    @Autowired
    private passengerMapper passengerMapper;
    //使用配置文件中的自定义变量20
    @Value("${user.passenger.max_count}")
    private Integer maxPassenger;
    @Override
    public void insertPassenger(Passenger passenger, Integer uid, String username) {
       //调用收货地址统计的方法
        Integer count= passengerMapper.countByUid(uid);
        if (count>=maxPassenger){
            throw new InsertCountLimitedException("passenger amount beyond the limitation");
        }
        //这个方法里补充剩余的数据
        passenger.setUid(uid);
        //1是默认 0不是默认
        Integer IsDefault = count==0?1:0;
        passenger.setIsDefault(IsDefault);
        passenger.setCreatedTime(new Date());
        passenger.setModifiedTime(new Date());
        passenger.setCreatedUser(username);
        passenger.setModifiedUser(username);
        Integer rows= passengerMapper.insert( passenger);
        if (rows!=1){
            throw new updateException("Unknown Exception");
        }
    }

    @Override
    public List<Passenger> getAllPassengerbyUid(Integer uid) {
      List<Passenger>  passengers= passengerMapper.findpassengerByUid(uid);
        return  passengers;
    }
}
