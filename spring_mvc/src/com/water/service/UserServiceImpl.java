package com.water.service;

import com.water.dao.UserMapper;
import com.water.pojo.QueryVo;
import com.water.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return userMapper.findUserByName(name);
    }

    @Override
    public List<User> selectUsersByQueryVo(QueryVo queryVo) {
        return userMapper.findUserByQueryVo(queryVo);
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

    @Override
    public Integer countUser() {
        return userMapper.countUsers();
    }

    @Override
    public List<User> userByUsernameAndPassword(User user) {
        return userMapper.selectUserByUsernameAndPassword(user);
    }

    @Override
    public List<User> userByIds(QueryVo vo) {
        return userMapper.selectUserByIds(vo);
    }
}
