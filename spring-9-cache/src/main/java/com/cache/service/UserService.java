package com.cache.service;

import com.cache.pojo.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {

    /**
     * redis会生成两个缓存。
     * 一个缓存是${value}~keys 是专门存储 #root.methodName的key的，虽然删除也是能正常取缓存数据的
     * 第二个就是key= #root.methodName value 为结果的缓存
     */
    @Cacheable(value = "cache", key = "#root.methodName")
    List<User> findAll();

    @Cacheable(value = "cache", key = "#root.args[0]")
    User findByUsername(String username);


    @CacheEvict(value = "cache", key = "#root.args[0]")
    @Transactional(rollbackFor = NullPointerException.class)
    void updateByUsername(String username);
}
