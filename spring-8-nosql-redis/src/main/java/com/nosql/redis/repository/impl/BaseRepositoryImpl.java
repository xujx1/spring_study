package com.nosql.redis.repository.impl;


import com.nosql.redis.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

class BaseRepositoryImpl<T> implements BaseRepository<T> {

    @Autowired
    private RedisTemplate<String, T> redisTemplate;

    public void setCache(String key, T t, int time, TimeUnit timeUnit) {
        deleteCache(key);
        redisTemplate.opsForValue().set(key, t, time, timeUnit);
    }

    public T getCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteCache(String key) {
        redisTemplate.delete(key);
    }

    public void updateCache(String key, T t, int time, TimeUnit timeUnit) {
        deleteCache(key);
        setCache(key, t, time, timeUnit);
    }
}
