package com.hello.service;

import com.hello.pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserService {
    private List<User> users = new ArrayList<User>();

    public UserService() {
        users = new ArrayList<User>(4);
        users.add(new User("user1"));
        users.add(new User("user2"));
        users.add(new User("user3"));
        users.add(new User("user4"));
    }

    public void addUser(String userName) {
        users.add(new User(userName));
    }

    public List<User> getUsers() {
        System.out.println("===============================");
        System.out.println(users.size());
        System.out.println("===============================");

        return users;
    }

}
