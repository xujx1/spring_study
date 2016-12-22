package com.jms.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jms.pojo.Order;
import com.jms.service.OrderService;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private ActiveMQTopic activeMQTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @JmsListener(destination = "topic.shop.order", containerFactory = "topicListenerContainerFactory")
    public void reciveOrder(String value) {
        assert StringUtils.isNotEmpty(value);
        Order order = null;
        try {
            order = objectMapper.readValue(value, Order.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("==========================");
        System.out.println("reciveOrder");
        System.out.println(order);
        System.out.println("==========================");
    }

    @Override
    public void sendOrder(Order order) {
        System.out.println("==========================");
        System.out.println("sendOrder");
        System.out.println(order);
        System.out.println("==========================");
        jmsTemplate.convertAndSend(activeMQTopic, order);
    }
}
