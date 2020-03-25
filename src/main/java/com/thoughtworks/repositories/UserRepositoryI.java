package com.thoughtworks.repositories;

import com.thoughtworks.entities.User;

import java.util.List;

public interface UserRepositoryI {
    void userRegister(User user);
    User login(String name, String password);
}
