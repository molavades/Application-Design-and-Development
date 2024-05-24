/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.UserAccountManagement;

import TheBusiness.Personnel.Profile;

/**
 *
 * @author kal bugrara
 */
public class UserAccount {

    Profile profile;
    private String username;
    private String password;

    public UserAccount(Profile profile, String un, String pw) {
        username = un;
        password = pw;
        this.profile = profile;

    }

    public String getPersonId() {
        return profile.getPerson().getPersonId();
    }

    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public boolean IsValidUser(String un, String pw) {

        if (getUsername().equalsIgnoreCase(un) && getPassword().equals(pw)) {
            return true;
        } else {
            return false;
        }

    }

    public String getRole() {
        return profile.getRole();
    }

    public Profile getAssociatedPersonProfile() {
        return profile;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

}
