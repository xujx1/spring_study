package com.nosql.service;


import com.nosql.pojo.User;

import java.util.List;

public interface UserService {

    List<User> list();


    List<User> list(String userName);


    User findOne(Integer id);


    void addUser(User user);


    void updateUser(User user) throws IllegalAccessException;


    void deletesUser(Integer[] integers);

    /**
     * 技术分割线
     */

    List<User> findUserName(String userName);


    List<User> findByUserNameLike(String userName);

}

