package com.water.dao;

import com.water.pojo.QueryVo;
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

    /**
     * 通过字符串
     * @param name 名字
     */
    List<User> findUserByName(String name);

    /**
     * 通过包装类
     * @param queryVo 包装类对象
     */
    List<User> findUserByQueryVo(QueryVo queryVo);

    Integer insertUser(User user);

    Integer deleteUser(User user);

    Integer updateUser(User user);

    Integer countUsers();

    /**
     * 通过用户名和密码查询
     */
    List<User> selectUserByUsernameAndPassword(User user);

    /**
     * 根据多个id查询
     */
    List<User> selectUserByIds(QueryVo queryVo);


}
