/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.iris.ui;

import com.iris.backend.controller.UserController;
import com.iris.backend.model.User;
import com.iris.ui.businessadmin.BusinessAdminScreen;
import com.iris.ui.cateringadmin.CateringAdminScreen;
import com.iris.ui.eventadmin.EventAdminScreen;
import com.iris.ui.eventmanager.EventManagerScreen;
import com.iris.ui.hoteladmin.HotelAdminScreen;
import com.iris.ui.hradmin.HRAdminScreen;
import com.iris.ui.travelagentadmin.TravelAgentAdminScreen;
import com.iris.ui.usermgmt.UserLayoutScreen;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JSplitPane;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aayuka Nirawade
 */
public class LoginJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginJPanel
     */
    JSplitPane mainSplitPane;

    UserController userController;

    public LoginJPanel(JSplitPane jSplitPane) throws SQLException {
        this.mainSplitPane = jSplitPane;
        initComponents();
        userController = new UserController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLocation = new javax.swing.JLabel();
        jUsernameTextField = new javax.swing.JTextField();
        jPasswordTextField = new javax.swing.JPasswordField();
        jLoginBtn = new com.iris.ui.resources.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(410, 620));
        setMinimumSize(new java.awt.Dimension(410, 620));
        setPreferredSize(new java.awt.Dimension(810, 620));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setText("Password");

        jLocation.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLocation.setForeground(new java.awt.Color(4, 72, 210));
        jLocation.setText("Iris Management System : Login");

        jPasswordTextField.setText("");

        jLoginBtn.setBackground(new java.awt.Color(255, 204, 0));
        jLoginBtn.setText("Login");
        jLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLocation)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jUsernameTextField)
                            .addComponent(jPasswordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 254, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLocation)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginBtnActionPerformed
        if (jUsernameTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a username.");
            jUsernameTextField.setBackground(new Color(255, 204, 203));
        } else if (jPasswordTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a password.");
            jPasswordTextField.setBackground(new Color(255, 204, 203));
        } else {
            String username = jUsernameTextField.getText();
            String password = jPasswordTextField.getText();
            try {
                int validUser = userController.validateUser(username, password);

                if (validUser == -1) {
                    JOptionPane.showMessageDialog(null, "Invalid credentials");
                } else if (validUser == -2) {
                    JOptionPane.showMessageDialog(null, "Awaiting business Admin approval!");
                } else {

                    ArrayList<User> userData = userController.getUserById(validUser);
                    String role = userData.get(0).getRole();

                    switch (role) {
                        case "Customer" -> {
                            UserLayoutScreen userLayoutScreen = new UserLayoutScreen(this.mainSplitPane, userData);
                            this.mainSplitPane.setRightComponent(userLayoutScreen.getBaseSplitPane().getRightComponent());
                            this.mainSplitPane.setLeftComponent(userLayoutScreen.getBaseSplitPane().getLeftComponent());
                        }
                        case "Business Admin" -> {
                            BusinessAdminScreen businessAdminScreen = new BusinessAdminScreen(this.mainSplitPane, userData);
                            this.mainSplitPane.setRightComponent(businessAdminScreen.getBaseSplitPane().getRightComponent());
                            this.mainSplitPane.setLeftComponent(businessAdminScreen.getBaseSplitPane().getLeftComponent());
                        }
                        case "Hotel Admin" -> {
                            HotelAdminScreen hotelAdminScreen = new HotelAdminScreen(this.mainSplitPane, userData);
                            this.mainSplitPane.setRightComponent(hotelAdminScreen.getBaseSplitPane().getRightComponent());
                            this.mainSplitPane.setLeftComponent(hotelAdminScreen.getBaseSplitPane().getLeftComponent());
                        }
                        case "Event Admin" -> {
                            EventAdminScreen eventAdminScreen = new EventAdminScreen(this.mainSplitPane, userData);
                            this.mainSplitPane.setRightComponent(eventAdminScreen.getBaseSplitPane().getRightComponent());
                            this.mainSplitPane.setLeftComponent(eventAdminScreen.getBaseSplitPane().getLeftComponent());
                        }
                        case "HR Admin" -> {
                            HRAdminScreen hrAdminScreen = new HRAdminScreen(this.mainSplitPane, userData);
                            this.mainSplitPane.setRightComponent(hrAdminScreen.getBaseSplitPane().getRightComponent());
                            this.mainSplitPane.setLeftComponent(hrAdminScreen.getBaseSplitPane().getLeftComponent());
                        }
                        case "Event Manager" -> {
                            EventManagerScreen eventManagerScreen = new EventManagerScreen(this.mainSplitPane, userData);
                            this.mainSplitPane.setRightComponent(eventManagerScreen.getBaseSplitPane().getRightComponent());
                            this.mainSplitPane.setLeftComponent(eventManagerScreen.getBaseSplitPane().getLeftComponent());
                        }
                        case "Catering Admin" -> {
                            CateringAdminScreen cateringAdminScreen = new CateringAdminScreen(this.mainSplitPane, userData);
                            this.mainSplitPane.setRightComponent(cateringAdminScreen.getBaseSplitPane().getRightComponent());
                            this.mainSplitPane.setLeftComponent(cateringAdminScreen.getBaseSplitPane().getLeftComponent());
                        }
                        case "TravelAgent Admin" -> {
                            TravelAgentAdminScreen travelAdminScreen = new TravelAgentAdminScreen(this.mainSplitPane, userData);
                            this.mainSplitPane.setRightComponent(travelAdminScreen.getBaseSplitPane().getRightComponent());
                            this.mainSplitPane.setLeftComponent(travelAdminScreen.getBaseSplitPane().getLeftComponent());
                        }
                        default -> {
                        }
                    }

                }
            } catch (SQLException ex) {
                System.out.println("error here.");
            }
        }
    }//GEN-LAST:event_jLoginBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLocation;
    private javax.swing.JButton jLoginBtn;
    private javax.swing.JPasswordField jPasswordTextField;
    private javax.swing.JTextField jUsernameTextField;
    // End of variables declaration//GEN-END:variables
}