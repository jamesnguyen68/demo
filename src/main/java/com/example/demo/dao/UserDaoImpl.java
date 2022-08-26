package com.example.demo.dao;

import com.example.demo.config.Constants;
import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    
private static final String ID = "iduser";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(Constants.SELECT_ALL_USER, new UserRowMapper());
    }

    @Override
    public List<User> findByFirstName() {
        return null;
    }

    @Override
    public List<User> findByLastName() {
        return null;
    }

    @Override
    public User findUserById(int id) {
        List<User> users = jdbcTemplate.query(Constants.SELECT_USER_BY_ID, new UserRowMapper(), id);
        logger.info("Size if users {}", users.toString());
        if (!users.isEmpty()) {
            return users.iterator().next();
        }
        return null;
    }

    @Override
    public int addUser(User user) {
        int result = -1;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(Constants.ADD_USER, new String[] { ID });
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public int updateUser(int id, User user) {
        int result = -1;
        try {
            result = jdbcTemplate.update(Constants.UPDATE_USER_BY_ID, user.getFirstName(), user.getLastName(), id);
        } catch (Exception e) {
            throw new RuntimeException("Cannot update user");
        }
        return result;
    }

    @Override
    public int deleteUser(int id) {
        int result = -1;
        try {
            result = jdbcTemplate.update(Constants.DELETE_USER_BY_ID, id);
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete user");
        }
        return result;
    }
}
