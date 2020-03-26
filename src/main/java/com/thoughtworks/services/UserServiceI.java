package com.thoughtworks.services;

import com.thoughtworks.entities.User;

public interface UserServiceI {
    String userRegister(User user);

    boolean isNameRight(String name);
    boolean isPhoneNumberRight(String phoneNumber);
    boolean isEmailRight(String email);
    boolean isPasswordRight(String password);
}
