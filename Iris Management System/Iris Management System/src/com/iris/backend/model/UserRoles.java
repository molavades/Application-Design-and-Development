/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iris.backend.model;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sushanthkumarreddyjanga
 */
public class UserRoles {

    public enum Roles {
        BUSINESS_ADMIN("Business Admin"),
        CUSTOMER("Customer"),
        HOTEL_ADMIN("Hotel Admin"),
        EVENT_ADMIN("Event Admin"),
        EVENT_MANAGER("Event Manager"),
        HR_ADMIN("HR Admin");

        private String value;

        private Roles(String value) {
            this.value = value;
        }
    }

    private List<Roles> getAllRoles() {
        return Arrays.asList(Roles.values());
    }

    private String getSelectedRole(final String roleName) {
        String dbRoleName = Roles.valueOf(roleName).toString();
        return dbRoleName;
    }
}
