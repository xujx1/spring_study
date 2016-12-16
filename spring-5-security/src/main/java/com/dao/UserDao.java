package com.dao;

import com.pojo.User;

import java.util.List;

public interface UserDao {

    List<User> list();

    User find(String userName);

    Integer add(String userName);
}
