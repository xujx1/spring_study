package com.jpa.service;

import com.jpa.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByUsername(String username);

    @Transactional(rollbackFor = NullPointerException.class)
    void updateByUsername(String username);
}
