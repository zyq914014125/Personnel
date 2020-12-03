package com.dao;

import com.entity.User;

import java.util.List;

public interface UserDao {
    User queryUser(String username);

    List<User> queryByRole(int role);

    List<User> queryByName(String name);

    void update(User user);

    void delete(String id);

    void updateAll(User user);

    void Insert(User user);
}
