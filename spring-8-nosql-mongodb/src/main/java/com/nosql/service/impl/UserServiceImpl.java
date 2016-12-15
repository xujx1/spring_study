package com.nosql.service.impl;

import com.nosql.pojo.User;
import com.nosql.repository.IUserRepository;
import com.nosql.repository.UserRepository;
import com.nosql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> list() {
        return userRepository.list();
    }

    @Override
    public List<User> list(String userName) {
        return userRepository.list(new Query(Criteria.where("userName").is(userName)));
    }

    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(new Query(Criteria.where("id").is(id)));
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) throws IllegalAccessException {
        userRepository.update(user);
    }

    @Override
    public void deletesUser(Integer[] integers) {
        userRepository.deletes(integers);
    }

    @Override
    public List<User> findUserName(String userName) {
        return iUserRepository.findByUserName(userName);
    }


    @Override
    public List<User> findByUserNameLike(String userName) {
        return iUserRepository.findByUserNameLike(userName);
    }
}
