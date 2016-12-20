package com.rpc.service.impl;

import com.rpc.pojo.User;
import com.rpc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> list() {
        return new ArrayList<>();
    }

    @Override
    public User findByUsername(String userName) {
        return new User(2, userName, "password");
    }
}
