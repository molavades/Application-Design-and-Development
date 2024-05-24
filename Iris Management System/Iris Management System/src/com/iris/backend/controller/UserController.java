/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iris.backend.controller;

import com.iris.backend.model.User;
import com.iris.backend.service.UserService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Snehal
 */
public class UserController {

    UserService userService;

    public UserController() throws SQLException {
        userService = new UserService();
    }

    public int insertUserDataController(int ID, String role, String name, String email, String phoneNum, String userName, String password, String path, String postalCode, String status) throws SQLException {
        return userService.insertUserDataService(ID, role, name, email,
                phoneNum, userName, password, path, postalCode, status);
    }

    public ArrayList<User> getUserDataByRole(String role) throws SQLException {
        return userService.getUserDataService(role);
    }

    public int validateUser(String userName, String password) throws SQLException {
        ArrayList<User> userList = userService.getUserDataByUserNamePswd(userName, password);
        for (User user : userList) {
            if (user.getStatus().equalsIgnoreCase("PENDING")) {
                return -2;
            }
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return user.getID();
            }
        }
        return -1;
    }

    public int getAllUsers() throws SQLException {
        ArrayList<User> userList = userService.getAllUsers();
        return userList.size() + 1;
    }

    public ArrayList<User> getUserById(int id) throws SQLException {
        return userService.getUserById(id);
    }

    public int updateUserPassword(ArrayList<User> userData, String oldPwd, String newPwd, String confirmPwd) throws SQLException {
        return userService.updateUserPasswordService(userData, oldPwd, newPwd, confirmPwd);
    }

    public ArrayList<User> getEventManagerList() throws SQLException {
        return userService.getEventManagerListService();
    }

    public int getUserByName(String name) throws SQLException {
        return userService.getUserByNameService(name);
    }

    public ArrayList<User> getMapleAdminAndManagerData() throws SQLException {
        return userService.getMapleAdminAndManagerDataService();
    }

    public ArrayList<User> getMapleAdminData() throws SQLException {
        return userService.getMapleAdminDataService();
    }

    public ArrayList<User> getMapleManagerData() throws SQLException {
        return userService.getMapleManagerDataService();
    }
}
