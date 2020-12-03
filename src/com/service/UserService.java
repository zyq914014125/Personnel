package com.service;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;

import java.util.List;

public class UserService {
    UserDao userDao=new UserDaoImpl();
    public User queryUser(String username) {
        return userDao.queryUser(username);
    }

    public List<User> queryByRole(int role) {
        return userDao.queryByRole(role);
    }

    public List<User> queryByName(String name) {
        return userDao.queryByName(name);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(String id) {
        userDao.delete(id);
    }

    public void updateAll(User user) {
        userDao.updateAll(user);
    }

    public void Insert(User user) {
        userDao.Insert(user);
    }
}
