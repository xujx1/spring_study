package com.jpa.service.impl;

import com.jpa.pojo.User;
import com.jpa.repository.UserRepository;
import com.jpa.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        assert StringUtils.isNotEmpty(username);
        return userRepository.findByUsername(username);
    }

    @Override
    public void updateByUsername(String username) {
        User user = this.findByUsername(username);
        if (null != user) {
            user.setEnabled(false);
        } else {
            user = new User(username, "password");

        }
        userRepository.save(user);
        LOGGER.info("user[{}]", user);
        throw new NullPointerException();
    }
}
