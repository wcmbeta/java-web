package com.water.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 包装对象
 * Created by Water on 2017/6/20.
 * Email:water471871679@gmail.com
 */
public class QueryVo  implements Serializable{
    private static final long serialVersionUID = 1L;
    private User user;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
