package com.water.service;

import com.water.dao.UserMapper;
import com.water.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Water on 2017/6/17.
 * Email:water471871679@gmail.com
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectItemsById(Integer id) {
        return userMapper.findUserById(id);
    }
}
