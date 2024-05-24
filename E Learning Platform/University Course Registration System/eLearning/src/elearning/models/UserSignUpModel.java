/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elearning.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harsh
 */
public class UserSignUpModel {

    private List<UserModel> userLi = new ArrayList<>();

    /**
     * @return the userLi
     */
    public List<UserModel> getUserLi() {
        return userLi;
    }

    /**
     * @param userLi the userLi to set
     */
    public void setUserLi(List<UserModel> userLi) {
        this.userLi = userLi;
    }

}
