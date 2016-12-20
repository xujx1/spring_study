package com.elasticsearch.service.impl;

import com.elasticsearch.pojo.User;
import com.elasticsearch.repository.UserRepository;
import com.elasticsearch.service.UserService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String userName) {

        List<User> users = userRepository.findByName(userName);
        for (User user : users) {
            userRepository.delete(user.getId());
        }
    }

    @Override
    public Iterable<User> search(String name) {
        return userRepository.search(QueryBuilders.multiMatchQuery(name, "name", "id"));
    }

    @Override
    public void updateUser(User user) {
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.source("name", user.getName());
        UpdateQuery updateQuery = new UpdateQueryBuilder().
                withId(String.valueOf(user.getId())).
                withClass(User.class).
                withIndexRequest(indexRequest).
                build();
        elasticsearchTemplate.update(updateQuery);
    }
}
