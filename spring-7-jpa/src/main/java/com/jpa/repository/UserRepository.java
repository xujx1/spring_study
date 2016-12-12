package com.jpa.repository;


import com.jpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    User findByUsername(String username);

}
