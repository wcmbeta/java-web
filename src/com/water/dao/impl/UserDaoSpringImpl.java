package com.water.dao.impl;

import com.water.dao.UserDao;
import com.water.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Created by Water on 17/5/22.
 * Email:water471871679@gmail.com
 */
public class UserDaoSpringImpl extends JdbcDaoSupport implements UserDao {
//    private JdbcTemplate jdbcTemplate;

//    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }

//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }


    @Override
    public void save(User user) {
        String sql = "insert into user ( 'name') values (?)";
        super.getJdbcTemplate().update(sql, user.getName());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from user where id = ?";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ? where id = ?";
        super.getJdbcTemplate().update(sql, user.getName(), user.getId());
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from user where id = ?";
        Object object = super.getJdbcTemplate().queryForObject(sql, User.class, id);
//        Object object = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet resultSet, int i) throws SQLException {
//                User user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("name"));
//                user.setUsername(resultSet.getString("username"));
//                user.setPassword(resultSet.getString("password"));
//                user.setAge(resultSet.getInt("age"));
//                return user;
//            }
//        }, id);

        return (User) object;
    }

    @Override
    public User getByName(String name) {
        String sql = "select * from user where name = ?";
        Object object = super.getJdbcTemplate().queryForObject(sql,new Object[]{name},new BeanPropertyRowMapper<User>(User.class));
        return (User) object;
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from user ";
        return super.getJdbcTemplate().queryForObject(sql,Integer.class);
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from user ";
        return super.getJdbcTemplate().query(sql,new Object[]{},new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User getUserByUserNamePassword(User user) {
        return null;
    }
}
