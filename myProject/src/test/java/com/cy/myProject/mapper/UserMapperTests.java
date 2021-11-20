package com.cy.myProject.mapper;


import com.cy.myProject.Mapper.UserMapper;

import com.cy.myProject.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest // 表示标注当前的类是一个测试类，不会随同项目一款打包
@RunWith(SpringRunner.class)//表示启动这个单元测试类（没有这个注解无法运行）需要传递一个参数必须是SpringRunner
// 的实例类型
public class UserMapperTests {
    //报错原因 idea有检测功能，接口是不能直接创建bean的
    @Autowired
    private UserMapper userMapper;
    @Test
   public void insert(){
       User user = new User();
       user.setUsername("test4");
       user.setPassword("123");
       Integer rows = userMapper.insert(user);
       System.out.println(rows);

//       单元测试满足条件：可以单独运行，不用启动项目
//       单元测试必须被test注解修饰
//       返回值类型必须是void
//        方法的参数列表不能指定任何类型否则报错
//      方法的访问修饰符必须是public
//

   }
    @Test
   public void select(){
        User user = new User();
        user.setUsername("qwe");
        User test = userMapper.findByUsername(user.getUsername());
        if (test!=null){
            System.out.println(1);
        }
   }
   @Test
    public void pupdatepassword(){
  userMapper.updatePasswordByUid(3, "321", "user", new Date());
    }
   @Test
    public void findid(){
       System.out.println(userMapper.findByUid(3).getUsername());

    }


    @Test
    public void updateUserInfo(){
        User user = new User();
        user.setUid(3);
        user.setGender(1);
        user.setPhone("2132132132");
        user.setEmail("sdasd@qq.com");
        userMapper.updateInfoByUid(user);

    }


    @Test
    public void updateAvatar(){
        User user = new User();
        user.setUid(3);
        userMapper.updateAvatarByuid(3,"te/image",user.getUsername(),new Date());

    }

    @Test
    public void testsignout(){
        userMapper.updatesignOutByuid("renshouda");
    }


}
