package com.thoughtworks.repositories;

import com.thoughtworks.entities.Account;
import com.thoughtworks.entities.User;

public interface UserRepositoryI {
    Boolean userRegister(User user);
    Account userLogin(String name, String password);
    Account isUserExist(String name);
    void updateErrorNo(String name, int errorNo);
    void updateStatus(String name, String status);
}
