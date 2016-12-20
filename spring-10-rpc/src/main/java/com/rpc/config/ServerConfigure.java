package com.rpc.config;

import com.rpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
@ComponentScan("com.rpc.service")
public class ServerConfigure {

    @Autowired
    private UserService userService;

    @Bean
    public RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(userService);
        rmiServiceExporter.setServiceName("UserService");
        rmiServiceExporter.setServiceInterface(UserService.class);
        //默认本机1099端口
        rmiServiceExporter.setRegistryPort(1199);
        return rmiServiceExporter;
    }
}
