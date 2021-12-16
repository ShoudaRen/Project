package com.cy.myProject.service;


import com.cy.myProject.Mapper.UserMapper;
import com.cy.myProject.entity.User;
import com.cy.myProject.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
// 的实例类型
public class UserServiceTests {
    @Autowired
    private IUserService userService;
    @Test
   public void reg(){
        //用户名设置不能和之前的重复
        //选中所要的line在 菜单code下选择Surrding with then ty catch
        try {
            User user = new User();
            user.setUsername("yuiio");
            user.setPassword("123");
            userService.reg(user); //在这里进行，密码加密
            System.out.println(1);
        } catch (ServiceException e) {
            //extract object name
            System.out.println(e.getClass().getSimpleName());
            //extract object concrete information
            System.out.println(e.getMessage());
        }

//       单元测试满足条件：可以单独运行，不用启动项目
//       单元测试必须被test注解修饰
//       返回值类型必须是void
//        方法的参数列表不能指定任何类型否则报错
//      方法的访问修饰符必须是public
//

   }
   @Test
   public void login(){
       User user= userService.login("yuiio","123");
       String a = user.getUsername();
       System.out.println(a);

   }

    @Test
    public  void updatePassword(){
        userService.changePassword(4, "qaz","123","456");
    }

    @Test
    public  void getById(){
        System.out.println(userService.getByuid(3).getUsername());
    }
    @Test
    public  void changeUserInfo(){
        User user = new User();
        user.setUid(3);
        user.setGender(0);
        user.setEmail("34234@dd");
        user.setPhone("2313131");
        userService.changeInfo(3,"gg",user);
    }

    @Test
    public  void changeAvatar(){
        userService.changeAvatar(3, "sfdf/23", "shouda");
    }

   }



