package com.cy.myProject.util;

//工具类
import java.io.Serializable;

//前后端响应的结果，要使用Json格式的数据进行响应
public class JsonResult<E> implements Serializable {
//   声明前端需要响应的数据
//    响应的状态码
    private Integer state;
//    响应的描述信息
    private String message;
//    响应对应的数据,因为属于通用接口前端的数据不确定 ，因此需要用泛型
    private E data;


    //后期方便调用（使三个属性在不同的场景下，设置相关的值）因此需要构造方法

    public JsonResult() {
    }
    //设置状态码
    public JsonResult(Integer state) {
        this.state = state;
    }
    // exception deliver
    public JsonResult(Throwable e) {
       this.message=e.getMessage();
    }
//状态码加数据
    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
