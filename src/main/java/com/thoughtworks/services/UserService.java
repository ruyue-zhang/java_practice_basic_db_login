package com.thoughtworks.services;

import com.thoughtworks.entities.User;
import com.thoughtworks.repositories.UserRepository;
import com.thoughtworks.repositories.UserRepositoryI;

public class UserService implements UserServiceI {
    private UserRepositoryI userRepository = new UserRepository();

    @Override
    public String userRegister(User user) {
        if (isNameRight(user.getName()) && isPhoneNumberRight(user.getPhoneNumber())
                && isEmailRight(user.getEmail()) && isPasswordRight(user.getPassword())) {
            System.out.println();
            if (userRepository.userRegister(user)) {
                return new String(user.getName() + ",恭喜你注册成功！");
            }
        } else if (!isNameRight(user.getName())) {
            return new String("用户名不合法\n请输入合法的注册信息：");
        } else if (!isPhoneNumberRight(user.getPhoneNumber())) {
            return new String("手机号不合法\n请输入合法的注册信息：");
        } else if(!isEmailRight(user.getEmail())) {
            return new String("邮箱不合法\n请输入合法的注册信息：");
        } else if(!isPasswordRight(user.getPassword())) {
            return new String("密码不合法\n请输入合法的注册信息：");
        }
        return new String("注册失败\n请输入合法的注册信息：");
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
