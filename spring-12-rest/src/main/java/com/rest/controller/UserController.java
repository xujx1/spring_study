package com.rest.controller;

import com.rest.pojo.User;
import com.rest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * 如果在控制器类上使用@RestController来代替@Controller的话，
 * Spring将会为该控制器的所有处理方法应用消息转换功能。
 * 我们不必为每个方法都添加@ResponseBody了。
 */
@RestController
@RequestMapping("/user")
class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/all")
    public List<User> findAll() {
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://localhost:8081/user/a", User.class);
        List<User> users = new ArrayList<>(1);
        users.add(responseEntity.getBody());
        return users;
    }

    @RequestMapping("{username}")
    public User findOne(@PathVariable("username") String username) {
        LOGGER.info("username：[{}]", username);
        return userService.findByUsername(username);
    }
}
