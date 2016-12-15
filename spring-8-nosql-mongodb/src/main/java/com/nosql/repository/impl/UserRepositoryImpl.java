package com.nosql.repository.impl;

import com.nosql.pojo.User;
import com.nosql.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

}
