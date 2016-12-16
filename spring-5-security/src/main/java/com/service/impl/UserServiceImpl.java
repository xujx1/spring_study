package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public User find(String userName) {
        assert StringUtils.isNotEmpty(userName);
        return userDao.find(userName);
    }


    @Override
    /*@Secured({"ROLE_USER"})*/
    /*@RolesAllowed("ROLE_USER")*/

    //设置入参判断
    @PreAuthorize("hasRole('ROLE_USER') and #userName.length() > 3")
    //设置初值判断
    //@PostAuthorize("returnObject==0")

    @PostAuthorize("(hasRole('ROLE_ADMIN') and returnObject==1) or hasRole('ROLE_USER')")
    public Integer add(String userName) {
        assert StringUtils.isNotEmpty(userName);
        return userDao.add(userName);
    }
}
