package com.thoughtworks.services;

import com.thoughtworks.entities.Account;
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
                return user.getName() + ",恭喜你注册成功！";
            }
        } else if (!isNameRight(user.getName())) {
            return "用户名不合法\n请输入合法的注册信息：";
        } else if (!isPhoneNumberRight(user.getPhoneNumber())) {
            return "手机号不合法\n请输入合法的注册信息：";
        } else if(!isEmailRight(user.getEmail())) {
            return "邮箱不合法\n请输入合法的注册信息：";
        } else if(!isPasswordRight(user.getPassword())) {
            return "密码不合法\n请输入合法的注册信息：";
        }
        return "注册失败\n请输入合法的注册信息：";
    }

    @Override
    public boolean userLogin(String name, String password) {
        if (isNameRight(name) && isPasswordRight(password)) {
            Account account = userRepository.isUserExist(name);
            if (account.getName() == null) {
                System.out.println("密码或用户名错误\n请重新输入用户名和密码：");
                return false;
            } else {
                if("locked".equals(account.getStatus())) {
                    System.out.println("您已3次输错密码，账号被锁定");
                    return false;
                } else {
                    Account account1 = userRepository.userLogin(name, password);
                    if (account1.getName() == null) {
                        if (account.getErrorNo() == 2) {
                            updateErrorNo(account.getName(), 0);
                            updateStatus(account.getName(), "locked");
                            System.out.println("您已3次输错密码，账号被锁定");
                            return false;
                        } else {
                            updateErrorNo(name, account.getErrorNo() + 1);
                            System.out.println("密码或用户名错误\n请重新输入用户名和密码：");
                            return false;
                        }
                    } else {
                        System.out.println(account.getName() + "，欢迎回来！\n您的手机号是" + account.getPhoneNumber() + "，邮箱是" + account.getEmail());
                        return false;
                    }
                }
            }
        } else {
            System.out.println("格式错误\n请按正确格式输入用户名和密码：");
            return false;
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

    @Override
    public void updateErrorNo(String name, int errorNo) {
        userRepository.updateErrorNo(name,errorNo);
    }

    @Override
    public void updateStatus(String name, String status) {
        userRepository.updateStatus(name,status);
    }
}
