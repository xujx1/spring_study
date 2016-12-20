package com.elasticsearch.service;

import com.elasticsearch.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findByName(String name);

    void addUser(User user);

    Iterable<User> findAll();

    void deleteUser(String userName);

    Iterable<User> search(String name);

    void updateUser(User user);

}
