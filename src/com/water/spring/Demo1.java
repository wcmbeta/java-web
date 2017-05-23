package com.water.spring;

import com.water.entity.Car;
import com.water.entity.User;
import com.water.utils.LogUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 基础demo
 * Created by Water on 17/5/17.
 * Email:water471871679@gmail.com
 */
public class Demo1 {
    @Test
    public void fun1() {
        LogUtils.info("Spring创建");
        //1 创建容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2 向容器中要对象
        User user = (User)applicationContext.getBean("user");
        Car car = (Car) applicationContext.getBean("car");
        //3 输出对象
        LogUtils.info(user.toString());
        LogUtils.info(car.toString());
        //4.销毁容器
        LogUtils.info("Spring销毁");
        applicationContext.close();
    }

    /**
     * 静态工厂创建
     */
    @Test
    public void fun2() {
        //1 创建容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2 向容器中要对象
        User user = (User)applicationContext.getBean("user2");
        //3 输出对象
        System.out.println(user.toString());
    }
    /**
     * 实例工厂创建
     */
    @Test
    public void fun3() {
        //1 创建容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2 向容器中要对象
        User user = (User)applicationContext.getBean("user3");
        //3 输出对象
        System.out.println(user.toString());
    }
}
