package com.thoughtworks.repositories;

import com.thoughtworks.entities.User;

public interface UserRepositoryI {
    Boolean userRegister(User user);
    User login(String name, String password);
}
