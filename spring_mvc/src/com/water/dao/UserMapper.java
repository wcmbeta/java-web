package com.water.dao;

import com.water.pojo.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by Water on 2017/6/17.
 * Email:water471871679@gmail.com
 */
@MapperScan
public interface UserMapper {
    User findUserById(Integer id);

    List<User> findUserByName( String name);

    Integer insertUser(User user);

    Integer deleteUser(User user);

    Integer updateUser(User user);
}
