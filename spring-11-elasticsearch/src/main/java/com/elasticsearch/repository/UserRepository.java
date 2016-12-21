package com.elasticsearch.repository;

import com.elasticsearch.pojo.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, Long> {
    List<User> findByChaNameOrEngNameOrSpellNameOrderByIdAsc(String chaName, String engName, String spellName);
}
