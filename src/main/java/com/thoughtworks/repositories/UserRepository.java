package com.thoughtworks.repositories;

import com.thoughtworks.entities.Account;
import com.thoughtworks.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public Account userLogin(String name, String password) {
        Connection conn = DbUtil.getConnection();
        Account account = new Account();
        String sql = "SELECT name,phone_number,email,error_number,status FROM user_info WHERE name = ? AND password = ?";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, name);
            ptmt.setString(2, password);
            ResultSet rs = ptmt.executeQuery();
            while(rs.next()) {
                account.setName(rs.getString("name"));
                account.setPhoneNumber(rs.getString("phone_number"));
                account.setEmail(rs.getString("email"));
                account.setErrorNo(rs.getInt("error_number"));
                account.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account isUserExist(String name) {
        Connection conn = DbUtil.getConnection();
        Account account = new Account();
        String sql = "SELECT name,phone_number,email,error_number,status FROM user_info WHERE name = ?";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, name);
            ResultSet rs = ptmt.executeQuery();
            while(rs.next()) {
                account.setName(rs.getString("name"));
                account.setPhoneNumber(rs.getString("phone_number"));
                account.setEmail(rs.getString("email"));
                account.setErrorNo(rs.getInt("error_number"));
                account.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void updateErrorNo(String name, int errorNo) {
        Connection conn = DbUtil.getConnection();
        String sql = "UPDATE user_info SET error_number = ? WHERE name = ?";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setInt(1, errorNo);
            ptmt.setString(2, name);
            ptmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(String name, String status) {
        Connection conn = DbUtil.getConnection();
        String sql = "UPDATE user_info SET status = ? WHERE name = ?";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, status);
            ptmt.setString(2, name);
            ptmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
