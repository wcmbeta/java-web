package com.water.spring.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.water.dao.UserDao;
import com.water.entity.User;
import com.water.utils.LogUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Water on 17/5/22.
 * Email:water471871679@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
    @Resource(name = "userDao")
    private UserDao userDao;


    @Test
    public void testSpringJdbc() throws PropertyVetoException {
        //0准备连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///test?characterEncoding=utf8&useSSL=true");
        dataSource.setUser("root");
        dataSource.setPassword("dickgo");
        //1创建jdbc连接
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源
        jdbcTemplate.setDataSource(dataSource);
        //2书写sql语句
        String sql = "select * from user";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                while (resultSet.next()) {
                    LogUtils.info(resultSet.getString("name"));
                }
            }
        });
    }
    @Test
    public void testSpringJdbcSave(){
        User user = new User();
        user.setName("tom");
        userDao.save(user);
    }
    @Test
    public void testSpringJdbcDelete(){
        User user = userDao.getByName("tom");
        userDao.delete(user.getId());
    }
    @Test
    public void testSpringJdbcUpdate(){
        User user = userDao.getByName("tom");
        user.setName("lucy");
        userDao.update(user);
    }
    @Test
    public void testSpringJdbcAll(){
        List<User> list = userDao.getAll();
        for (User u : list) {
            LogUtils.info("user"+u.toString());
        }

    }

}
