package com.thoughtworks.services;

import com.thoughtworks.entities.User;

public interface UserServiceI {
    String userRegister(User user);
    boolean userLogin(String name,String password);

    boolean isNameRight(String name);
    boolean isPhoneNumberRight(String phoneNumber);
    boolean isEmailRight(String email);
    boolean isPasswordRight(String password);

    void updateErrorNo(String name, int errorNo);

    void updateStatus(String name, String status);
}
