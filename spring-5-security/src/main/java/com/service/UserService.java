package com.service;

import com.pojo.User;

import java.util.List;

public interface UserService {

    List<User> list();

    User find(String userName);


    /**
     * ROOT有添加管理员的权限
     */
    Integer add(String userName);
}
