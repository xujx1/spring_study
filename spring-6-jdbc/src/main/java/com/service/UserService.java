package com.service;

import com.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findUsers();

    void addUser(User user);
}
