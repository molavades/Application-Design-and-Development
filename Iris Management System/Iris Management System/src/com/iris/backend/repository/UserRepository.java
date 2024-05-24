/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iris.backend.repository;

import com.iris.db.config.JDBC;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Snehal
 */
public class UserRepository {

    JDBC obj;

    public UserRepository() throws SQLException {
        obj = JDBC.getInstance();
    }

    public void insertUserData(int ID, String role, String name, String email, String phoneNum, String userName, String password, String path, String postalCode, String status) throws SQLException {
        String sql = "insert into user (id, role, name, email, phoneNumber, username, password, photo, postalCode, status)"
                + "values('" + ID + "','" + role + "','" + name + "','" + email + "','" + phoneNum + "','" + userName + "','" + password + "','" + path + "','" + postalCode + "','" + status + "')";
        obj.update(sql, new String[]{});
        JOptionPane.showMessageDialog(null, "You are registered!");
    }

    public ResultSet getUserData(String role) throws SQLException {
        String sql = "select * from user where role = '" + role + "'";
        return obj.query(sql, new String[]{});
    }

    public ResultSet getUserDataByUserName(String username) throws SQLException {
        String sql = "select * from user where username = '" + username + "'";
        return obj.query(sql, new String[]{});
    }

    public ResultSet getUserDataByUserNamePswd(String username, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        return obj.query(sql, new String[]{});
    }

    public ResultSet getAllUsers() throws SQLException {
        String sql = "select * from user";
        return obj.query(sql, new String[]{});
    }

    public ResultSet getUserById(int id) throws SQLException {
        String sql = "select * from user where id = " + id;
        return obj.query(sql, new String[]{});
    }

    public void updateUserPassword(String newPwd, int id) throws SQLException {
        String sql = "UPDATE USER SET password = '" + newPwd + "' WHERE id = " + id;
        obj.update(sql, new String[]{});
    }

    public void updateUserStatus(int id, String status) throws SQLException {
        String sql = "UPDATE USER SET STATUS = '" + status + "' WHERE id = " + id;
        obj.update(sql, new String[]{});
    }

}
