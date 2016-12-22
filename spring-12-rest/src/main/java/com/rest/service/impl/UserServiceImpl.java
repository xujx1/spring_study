package com.rest.service.impl;

import com.rest.pojo.User;
import com.rest.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        return new ArrayList<>();
    }

    @Override
    public User findByUsername(String username) {
        return new User(username, "password");
    }
}
