package com.thoughtworks.repositories;

import com.thoughtworks.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

public class UserRepository implements UserRepositoryI{
    @Override
    public Boolean userRegister(User user) {
        Connection conn = DbUtil.getConnection();
        String sql = "INSERT INTO user_info (id,name,phone_number,email,password,error_number,status) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, null);
            ptmt.setString(2, user.getName());
            ptmt.setString(3, user.getPhoneNumber());
            ptmt.setString(4, user.getEmail());
            ptmt.setString(5, user.getPassword());
            ptmt.setInt(6, 0);
            ptmt.setString(7,"unlocked");
            ptmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User login(String name, String password) {
        return null;
    }
}
