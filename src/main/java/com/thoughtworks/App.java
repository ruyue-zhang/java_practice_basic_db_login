package com.thoughtworks;

import com.thoughtworks.entities.User;
import com.thoughtworks.repositories.UserRepository;
import com.thoughtworks.repositories.UserRepositoryI;

public class App {

  public static void main(String[] args) {
    User user = new User("张三","18829290872","1234567@qq.com","1234567");
    UserRepositoryI zhangsan = new UserRepository();
    zhangsan.userRegister(user);
  }
}
