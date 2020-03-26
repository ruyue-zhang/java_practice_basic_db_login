package com.thoughtworks;

import com.thoughtworks.controllers.UserController;
import com.thoughtworks.entities.User;
import com.thoughtworks.repositories.UserRepository;
import com.thoughtworks.repositories.UserRepositoryI;
import com.thoughtworks.services.UserService;
import com.thoughtworks.services.UserServiceI;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    UserController userController = new UserController();

    boolean loginResult = true;
    while(loginResult) {
      System.out.println("1. 注册");
      System.out.println("2. 登录");
      System.out.println("3. 退出");
      System.out.println("请输入你的选择(1~3):");
      Scanner input = new Scanner(System.in);
      int index = input.nextInt();
      switch (index) {
        case 1:
          System.out.println("请输入注册信息(格式：用户名,手机号,邮箱,密码)：");
          String userInfo = input.next();
          String[] split = userInfo.split(",");
          User user = new User(split[0], split[1], split[2], split[3]);
          System.out.println(userController.userRegister(user));
          break;
        case 2:
          System.out.println("登录");
          loginResult = false;
          break;
        case 3:
          break;
      }
    }
  }
}
