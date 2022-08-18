package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();
    User findUserById(int id);
    User create(User user);
    User updateUser(int i, User user);
    int deleteUser(int id);

}
