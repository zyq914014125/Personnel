package com.dao.impl;

import com.dao.UserDao;
import com.entity.User;
import com.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    //jdbctemplate
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User queryUser(String username) {
        String sql="Select * from user where username=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),username);
    }

    @Override
    public List<User> queryByRole(int role) {
        String sql="Select * from user where role>?";
        return template.query(sql,new BeanPropertyRowMapper<>(User.class),role);
    }

    @Override
    public List<User> queryByName(String name) {
        String sql="Select * from user where name=?";
        return template.query(sql,new BeanPropertyRowMapper<>(User.class),name);
    }

    @Override
    public void update(User user) {
        String sql="UPDATE  user SET name=?,telephone=?,address=?,sex=?,age=? WHERE user_id=?";
        template.update(sql,user.getName(),user.getTelephone(),user.getAddress(),user.getSex(),user.getAge(),user.getUser_id());
    }

    @Override
    public void delete(String id) {
        String sql="DELETE from user where user_id=?";
        template.update(sql,id);
    }

    @Override
    public void updateAll(User user) {
        String sql="UPDATE  user SET name=?,telephone=?,address=?,sex=?,age=?,username=?,password=? WHERE user_id=?";
        template.update(sql,user.getName(),user.getTelephone(),user.getAddress(),user.getSex(),user.getAge(),user.getUsername(),user.getPassword(),user.getUser_id());
    }

    @Override
    public void Insert(User user) {
        String sql="INSERT INTO user (username,password,name,telephone,address,sex,age,role,roleName) VALUES(?,?,?,?,?,?,?,?,?);";
        template.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getTelephone(),user.getAddress(),user.getSex(),user.getAge(),user.getRole(),user.getRoleName());
    }
}
