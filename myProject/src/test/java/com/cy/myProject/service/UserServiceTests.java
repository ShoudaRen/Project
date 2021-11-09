package com.cy.myProject.service;


import com.cy.myProject.Mapper.UserMapper;
import com.cy.myProject.entity.User;
import com.cy.myProject.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest // 表示标注当前的类是一个测试类，不会随同项目一款打包
@RunWith(SpringRunner.class)//表示启动这个单元测试类（没有这个注解无法运行）需要传递一个参数必须是SpringRunner
// 的实例类型
public class UserServiceTests {
    //报错原因 idea有检测功能，接口是不能直接创建bean的
    @Autowired
    private IUserService userService;
    @Test
   public void reg(){
        //用户名设置不能和之前的重复
        //选中所要的line在 菜单code下选择Surrding with then ty catch
        try {
            User user = new User();
            user.setUsername("tim2");
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

   }



