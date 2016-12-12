package com.jpa.controller;

import com.jpa.pojo.User;
import com.jpa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("/all")
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping("{username}")
    @ResponseBody
    public User findOne(@PathVariable("username") String username) {
        LOGGER.info("username：[{}]", username);
        return userService.findByUsername(username);
    }

    @RequestMapping("/update/{username}")
    @ResponseBody
    public void update(@PathVariable("username") String username) {
        LOGGER.info("username：[{}]", username);
        userService.updateByUsername(username);
    }
}
