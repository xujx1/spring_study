package com.nosql.repository;

import com.nosql.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 继承扩展MongoRepository
 */
public interface IUserRepository extends MongoRepository<User, String> {
    List<User> findByUserName(String userName);

    List<User> findByUserNameLike(String userName);
}
