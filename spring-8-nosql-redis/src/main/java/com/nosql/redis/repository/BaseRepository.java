package com.nosql.redis.repository;


import java.util.concurrent.TimeUnit;

public interface BaseRepository<T> {

    void setCache(String key, T t, int time, TimeUnit timeUnit);

    T getCache(String key);

    void deleteCache(String key);

    void updateCache(String key, T t, int time, TimeUnit timeUnit);

}
