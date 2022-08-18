package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    List<User> findByFirstName();
    List<User> findByLastName();

    User findUserById(int id);
    int addUser(User user);
    int updateUser(int id, User user);
    int deleteUser(int id);
}
