package com.thoughtworks.controllers;

import com.thoughtworks.entities.User;
import com.thoughtworks.services.UserService;

public class UserController {
    private UserService userService = new UserService();

    public String userRegister(User user) {
        return userService.userRegister(user);
    }

}
