package com.rest.service;

import com.rest.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByUsername(String username);
}
