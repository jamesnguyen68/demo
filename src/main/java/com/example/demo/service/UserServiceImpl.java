package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUser() {
        List<User> result = userDao.findAll();
        return result;
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public User create(User user) {
        int id = userDao.addUser(user);
        if (id != -1) {
            return userDao.findUserById(id);
        }
        return null;
    }

    @Override
    public User updateUser(int id, User user) {
        int storedId = userDao.updateUser(id, user);
        //read after write
        return userDao.findUserById(id);
    }

    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

}
