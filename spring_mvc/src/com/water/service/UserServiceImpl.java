package com.water.service;

import com.water.dao.UserMapper;
import com.water.pojo.User;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Water on 2017/6/17.
 * Email:water471871679@gmail.com
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<User> selectUsersByName(String name) {
        return (List<User>) userMapper.findUserByName(name);
    }

    @Override
    public Integer inserUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Integer deleteUser(User user) {
         return userMapper.deleteUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
