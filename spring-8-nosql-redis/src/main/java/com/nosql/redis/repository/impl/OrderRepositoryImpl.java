package com.nosql.redis.repository.impl;

import com.nosql.redis.pojo.Order;
import com.nosql.redis.repository.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl extends BaseRepositoryImpl<Order> implements OrderRepository {

}
