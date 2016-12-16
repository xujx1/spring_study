package com.cache.service;

import com.cache.pojo.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {

    @Cacheable(value = "Cache", key = "#root.methodName ")
    List<User> findAll();

    @Cacheable(value = "Cache", key = "#root.args[0]")
    User findByUsername(String username);



    @CacheEvict(value = "Cache", key = "#root.args[0]")
    @Transactional(rollbackFor = NullPointerException.class)
    void updateByUsername(String username);
}
