package com.hello.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -384276325658324676L;

    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
