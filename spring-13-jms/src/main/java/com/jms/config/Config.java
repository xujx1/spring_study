package com.jms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(value = JmsConfig.class)
@ComponentScan("com.jms.service")
@PropertySource(value = "classpath:activemq.properties")
public class Config {
}
