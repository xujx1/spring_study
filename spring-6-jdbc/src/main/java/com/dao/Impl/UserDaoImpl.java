package com.dao.Impl;

import com.dao.UserDao;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Value("${USERS_QUERY}")
    private String USERS_QUERY;

    @Value("${USERS_INSERT}")
    private String USERS_INSERT;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findUsers() {
        return jdbcTemplate.query(USERS_QUERY, (resultSet, i) -> {
            User user = new User();
            user.setUsername(resultSet.getString("username"));
            return user;
        });
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(USERS_INSERT,user.getUsername(),user.getEnabled(),user.getPassword(),user.getRole());
    }
}
