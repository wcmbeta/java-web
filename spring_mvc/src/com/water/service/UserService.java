package com.water.service;

import com.water.pojo.QueryVo;
import com.water.pojo.User;

import java.util.List;

/**
 * Created by Water on 2017/6/17.
 * Email:water471871679@gmail.com
 */
public interface UserService {
    User selectUserById(Integer id);

    List<User> selectUsersByName(String name);

    /**
     * 查询
     * @param queryVo 包装对象
     */
    List<User> selectUsersByQueryVo(QueryVo queryVo);

    Integer inserUser(User user);

    Integer deleteUser(User user);

    Integer updateUser(User user);

    /**
     * 简单统计
     */
    Integer countUser();

    /**
     * 动态sql查询用户
     */
    List<User> userByUsernameAndPassword(User user);

    /**
     * 多个id查询
     */
    List<User> userByIds(QueryVo vo);
}
