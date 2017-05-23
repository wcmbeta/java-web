package com.water.dao;

import com.water.entity.User;

import java.util.List;

/**
 * Created by Water on 17/5/22.
 * Email:water471871679@gmail.com
 */
public interface UserDao {
    /**
     * 保存
     * @param user
     */
    void save(User user);

    /**
     * 删除用户
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新某个用户
     * @param user
     */
    void update(User user);
    //查
    User getById(Integer id);

    /**
     * 通过用户名查询
     * @param name
     * @return
     */
    User getByName(String name);

    /**
     * 获取总数
     * @return int
     */
    int getTotalCount();

    /**
     * 获取全部用户
     * @return List<User>
     */
    List<User> getAll();

}
