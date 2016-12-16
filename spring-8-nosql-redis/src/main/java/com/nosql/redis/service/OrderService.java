package com.nosql.redis.service;

import com.nosql.redis.pojo.Order;

import java.util.concurrent.TimeUnit;

public interface OrderService {

    void setCache(String key, Order order, int time, TimeUnit timeUnit);

    Order getCache(String key);

    void deleteCache(String key);

    void updateCache(String key, Order order, int time, TimeUnit timeUnit);
}
