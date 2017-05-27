package com.water.service.impl;

import com.water.dao.UserDao;
import com.water.entity.User;
import com.water.service.UserService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Water on 17/5/23.
 * Email:water471871679@gmail.com
 */
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = true)
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao2")
    private UserDao userDao;

    @Override
    //注解事务
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public User find(final String name) {
        User user = userDao.getByName(name);
//        LogUtils.info("ssh-整合测试");
        return user;

    }

    @Override
    public User getUserByUserNamePassword(User u) {
        //查登录用户
        User user = userDao.getUserByUserNamePassword(u);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!user.getPassword().equals(u.getPassword())) {
            throw new RuntimeException("密码不正确");
        }
        return user;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
