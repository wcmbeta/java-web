package com.water.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.water.entity.User;
import com.water.service.UserService;
import com.water.utils.LogUtils;

/**
 * Created by Water on 17/5/23.
 * Email:water471871679@gmail.com
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
    private UserService userService;
    private User user = new User();
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String test() throws Exception {
        userService.find("老王");
        return SUCCESS;
    }

    public String save() throws Exception {
        User user = new User("牵牛","abcd","1234");
        userService.save(user);
        return SUCCESS;
    }

    public String login()throws Exception{
        LogUtils.info("username:"+user.getUsername()+",password:"+user.getPassword());
        User u = userService.getUserByUserNamePassword(user);
        //放入session域
        ActionContext.getContext().getSession().put("user",u);
        return "toHome";
    }


    @Override
    public User getModel() {
        return user;
    }


}
