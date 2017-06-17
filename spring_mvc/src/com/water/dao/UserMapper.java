package com.water.dao;

import com.water.pojo.User;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by Water on 2017/6/17.
 * Email:water471871679@gmail.com
 */
@MapperScan
public interface UserMapper {
    User findUserById(Integer id);
}
