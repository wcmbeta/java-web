package com.water.service;

import com.water.pojo.User;

import java.util.List;

/**
 * Created by Water on 2017/6/17.
 * Email:water471871679@gmail.com
 */
public interface UserService {
    User selectUserById(Integer id);

    List<User> selectUsersByName(String name);

    Integer inserUser(User user);

    Integer deleteUser(User user);

    Integer updateUser(User user);
}
