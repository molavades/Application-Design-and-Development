/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.UserAccountManagement;

import TheBusiness.Personnel.*;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> useraccountlist;

    /**
     * @return the useraccountlist
     */
    public ArrayList<UserAccount> getUseraccountlist() {
        return useraccountlist;
    }

    public UserAccountDirectory() {

        useraccountlist = new ArrayList();

    }

    public UserAccount newUserAccount(Profile p, String un, String pw) {

        UserAccount ua = new UserAccount(p, un, pw);
        getUseraccountlist().add(ua);
        return ua;
    }

    public UserAccount findUserAccount(String id) {

        for (UserAccount ua : getUseraccountlist()) {

            if (ua.isMatch(id)) {
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }

    public UserAccount AuthenticateUser(String un, String pw) {

        for (UserAccount ua : getUseraccountlist()) {

            if (ua.IsValidUser(un, pw)) {
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }
}
