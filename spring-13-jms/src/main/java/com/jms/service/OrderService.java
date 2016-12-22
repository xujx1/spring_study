package com.jms.service;

import com.jms.pojo.Order;

public interface OrderService {
    void reciveOrder(String value);

    void sendOrder(Order order);
}
