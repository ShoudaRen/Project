package com.cy.myProject.service.impl;
/**
 * 只处理前端需要的数据的类
 * 具体实现类
 * 使用异常的情况执行实现
 */
import com.cy.myProject.Mapper.UserMapper;
import com.cy.myProject.entity.User;
import com.cy.myProject.service.IUserService;
import com.cy.myProject.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.Date;
import java.util.UUID;

@Service  //不加这个报错  将当前类的对象交给Spring来管理，自动创建对象以及维护
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
    //先检测用户名是否被注册过 调用findByusername(username);
        User result= userMapper.findByUsername(user.getUsername());
         if(result!=null){
             //throw exception
             throw new UsernameDuplicatedException("The user name already exists");
         }else{
             //加密  md5算法的形式
          String oldPassword = user.getPassword();
          //获取salt(随机生成一个盐值)
             // UUID API，随机生成串
             String salt= UUID.randomUUID().toString().toUpperCase();
             //salt like a key , need to be documented
             user.setSalt(salt);
//             step 3 , put passward and salt as an integate to cy
           String MD5Password=  getMD5Password(oldPassword,salt);
           //加密之后重新设置到user对象
             user.setPassword(MD5Password);

//             Reset the configuration
             user.setIsDelete(0);
             user.setCreatedUser(user.getUsername());
             user.setModifiedUser(user.getUsername());
             Date date=new Date();
             user.setCreatedTime(date);
             user.setModifiedTime(date);
             //carry out register insert row
            Integer rows= userMapper.insert(user);
            if (rows!=1){
                throw new InsertException("oops! An unknown error");
            }
         }
    }
// 实现父接口中的方法
    public User login(String username, String password){
        //先查询用户数据是否存在
        User result=userMapper.findByUsername(username);
        if (result==null){
            throw new UserNotFoundException("User not exists ");
        }
        //判断 is_delete字段是否为1
        if (result.getIsDelete()==1){
            throw new UserNotFoundException("User data not exists");
        }
       //检测密码是否匹配
        String salt= result.getSalt();
        String newMd5Password = getMD5Password(password,salt);
        //get password in database
        String oldPassword= result.getPassword();
        //get salt in database
            if (!oldPassword.equals(newMd5Password)){
                throw new PasswordNotMatchException("password wrong");
            }

       //如果之前都没报错，执行这个
       User user= userMapper.findByUsername(username);
        //下面的方法提升了系统的性能，减少数据的调用
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result =userMapper.findByUid(uid);
        if (result==null||result.getIsDelete()==1){
            throw new UserNotFoundException("user data does not exist");
        }
      String oldMd5Password=  getMD5Password(oldPassword,result.getSalt());
        if (!result.getPassword().equals(oldMd5Password)){
            throw new PasswordNotMatchException("password wrong");
        }
//        将新的密码设置到数据库中，将新的密码进行加密再去更新
        String newMd5Password=getMD5Password(newPassword,result.getSalt());
  //更新数据库
     Integer rows= userMapper.updatePasswordByUid(uid,newMd5Password,username,new Date());
     if (rows!=1){
         throw new updateException("update Exception");
     }
    }

    /**
     * 页面显示信息功能支持
     * @param uid
     * @return
     */
    @Override
    public User getByuid(Integer uid) {
       User result= userMapper.findByUid(uid);
       if (result==null||result.getIsDelete()==1){
           throw new UserNotFoundException("the user does not exist");
       }
//       因为只要四个数据所以来个过度可以提高性能，控制层使用服务层的这个方法获得user对象并把它放在
//       json中传给前端，前端检测到检测到打开这个页面然后加载json数据，然后用Jquery设置到页面
        User user = new User();
       user.setUsername(result.getUsername());
       user.setPhone(result.getPhone());
       user.setEmail(result.getEmail());
       user.setGender(result.getGender());
        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
//       检测数据存在不
        User result= userMapper.findByUid(uid);
        if (result==null||result.getIsDelete()==1){
            throw new UserNotFoundException("the user does not exist");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        //在表里更新数据
        Integer rows=userMapper.updateInfoByUid(user);
        if (rows!=1){
            throw new updateException("Unknown Exception");
        }
    }








    //    定义一个加密方法
    private String getMD5Password(String password, String salt){
        // DigestUtils 加密算法(需要进行3次加密)
        for (int i = 0; i < 3; i++) {
           password= DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }

        return password;

    }
}
