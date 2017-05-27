package com.water.service;

import com.water.entity.User;

/**
 * Created by Water on 17/5/23.
 * Email:water471871679@gmail.com
 */
public interface UserService {
    void save(User user);
    void delete();
    void update();
    User find(String name);

    User getUserByUserNamePassword(User user);

}
