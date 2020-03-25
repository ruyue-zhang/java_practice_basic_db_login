package com.thoughtworks.services;

import com.thoughtworks.entities.User;
import com.thoughtworks.repositories.UserRepository;
import com.thoughtworks.repositories.UserRepositoryI;

import java.util.UUID;

public class UserService implements UserServiceI {
    private UserRepositoryI userRepository = new UserRepository();
    @Override
    public void userRegister(User user) {
        if(isNameRight(user.getName()) && isPhoneNumberRight(user.getPhoneNumber())
                && isEmailRight(user.getEmail()) && isPasswordRight(user.getPassword()) ) {
            userRepository.userRegister(user);
        } else {
            System.out.println("格式错误\n请按正确格式输入注册信息：");
        }
    }

    public boolean isNameRight(String name) {
        String regex = "^.{2,10}$";
        return name.matches(regex);
    }

    public boolean isPhoneNumberRight(String phoneNumber) {
        String regex = "^1[0-9]{10}$";
        return phoneNumber.matches(regex);
    }

    public boolean isEmailRight(String email) {
        String regex = "^[A-Za-z0-9]+@([_A-Za-z0-9]+\\.)+[A-Za-z0-9]{2,3}$";
        return email.matches(regex);
    }

    public boolean isPasswordRight(String password) {
        String regex = "^(.*[0-9]+.*)(.*[a-zA-Z]+.*)$";
        return password.matches(regex);
    }
}
