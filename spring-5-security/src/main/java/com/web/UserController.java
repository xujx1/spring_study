package com.web;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public User hello(@PathVariable("userName") String userName) {
        return userService.find(userName);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> list() {
        return userService.list();
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public List<User> hello() {
        return userService.list();
    }


    @RequestMapping(value = "add/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public void add(@PathVariable("userName") String userName) {
        userService.add(userName);
    }
}
