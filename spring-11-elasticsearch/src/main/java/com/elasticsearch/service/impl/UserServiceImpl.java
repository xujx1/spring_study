package com.elasticsearch.service.impl;

import com.elasticsearch.pojo.User;
import com.elasticsearch.repository.UserRepository;
import com.elasticsearch.service.UserService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
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
        return userRepository.findByChaNameOrEngNameOrSpellNameOrderByIdAsc(name, name, name);
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

        List<User> users = userRepository.findByChaNameOrEngNameOrSpellNameOrderByIdAsc(userName, userName, userName);
        for (User user : users) {
            userRepository.delete(user.getId());
        }
    }

    @Override
    public Iterable<User> search(String name) {

        QueryBuilder queryBuilder = QueryBuilders.boolQuery().
                //boost设置权重
                        should(QueryBuilders.prefixQuery("spellName", name).boost(1f)).
                        should(QueryBuilders.prefixQuery("engName", name).boost(10f)).
                        should(QueryBuilders.matchQuery("chaName", name).boost(100f));

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).withSort(SortBuilders.scoreSort()).build();
        elasticsearchTemplate.queryForList(new NativeSearchQueryBuilder().withQuery(queryBuilder).withSort(SortBuilders.scoreSort().order(SortOrder.DESC)).build(), User.class).forEach(System.out::println);
        System.out.println("=====================================");
        return elasticsearchTemplate.queryForList(searchQuery, User.class);
       /* return userRepository.search(QueryBuilders.multiMatchQuery(name, "chaName", "engName", "spellName").field("chaName", 100f).field("engName", 10f).field("spellName", 1f));*/
    }

    @Override
    public void updateUser(User user) {
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.source("chaName", user.getChaName());
        indexRequest.source("engName", user.getEngName());
        indexRequest.source("spellName", user.getSpellName());
        UpdateQuery updateQuery = new UpdateQueryBuilder().
                withId(String.valueOf(user.getId())).
                withClass(User.class).
                withIndexRequest(indexRequest).
                build();
        elasticsearchTemplate.update(updateQuery);
    }
}
