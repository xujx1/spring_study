package com.web;

import com.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Value("${USER_BY_USERNAME_QUERY}")
    private String USER_BY_USERNAME_QUERY;

    @Value("${USERS_QUERY}")
    private String USERS_QUERY;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    @ResponseBody
    public User hello(String userName) {
        assert StringUtils.isNotEmpty(userName);
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> list() {
        return jdbcTemplate.query(USERS_QUERY, (resultSet, i) -> {
            User user = new User();
            user.setUserName(resultSet.getString("username"));
            return user;
        });
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public List<User> hello() {
        return jdbcTemplate.query(USERS_QUERY, (resultSet, i) -> {
            User user = new User();
            user.setUserName(resultSet.getString("username"));
            return user;
        });
    }
}
