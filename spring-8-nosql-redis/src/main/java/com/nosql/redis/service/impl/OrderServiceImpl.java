package com.nosql.redis.service.impl;

import com.nosql.redis.pojo.Order;
import com.nosql.redis.repository.OrderRepository;
import com.nosql.redis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderDao;

    @Override
    public void setCache(String key, Order order, int time, TimeUnit timeUnit) {
        orderDao.setCache(key, order, time, timeUnit);
    }

    @Override
    public Order getCache(String key) {
        return orderDao.getCache(key);
    }

    @Override
    public void deleteCache(String key) {
        orderDao.deleteCache(key);
    }

    @Override
    public void updateCache(String key, Order order, int time, TimeUnit timeUnit) {
        orderDao.updateCache(key, order, time, timeUnit);
    }
}
