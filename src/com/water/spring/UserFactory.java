package com.water.spring;

import com.water.entity.User;

/**
 *
 * Created by Water on 17/5/17.
 * Email:water471871679@gmail.com
 */
public class UserFactory {
    public static User createUser(){
        //UserFactory.createUser();
        System.out.println("静态工厂创建User");
        return new User();
    }
    public User createUser2(){
        //new UserFactory().createUser2();
        System.out.println("实例工厂创建User");
        return new User();
    }
}
