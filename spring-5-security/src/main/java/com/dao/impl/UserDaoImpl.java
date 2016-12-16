package com.dao.impl;

import com.dao.UserDao;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Value("${USER_BY_USERNAME_QUERY}")
    private String USER_BY_USERNAME_QUERY;

    @Value("${USERS_QUERY}")
    private String USERS_QUERY;

    @Value("${USER_INSERT}")
    private String USER_INSERT;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> list() {
        return jdbcTemplate.query(USERS_QUERY, (resultSet, i) -> {
            User user = new User();
            user.setUserName(resultSet.getString("username"));
            return user;
        });
    }

    @Override
    public User find(String userName) {
        User user = null;
        List<User> users = jdbcTemplate.query(USER_BY_USERNAME_QUERY, new Object[]{userName}, (resultSet, i) -> {
            User user1 = new User();
            user1.setUserName(resultSet.getString("username"));
            return user1;
        });
        if (!CollectionUtils.isEmpty(users)) {
            user = users.get(0);
        }
        return user;
    }

    @Override
    public Integer add(String userName) {
        return jdbcTemplate.update(USER_INSERT, userName, "password", "USER");
    }
}
