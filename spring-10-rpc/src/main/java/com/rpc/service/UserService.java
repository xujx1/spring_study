package com.rpc.service;

import com.rpc.pojo.User;

import java.util.List;

public interface UserService {

    List<User> list();

    User findByUsername(String userName);
}
