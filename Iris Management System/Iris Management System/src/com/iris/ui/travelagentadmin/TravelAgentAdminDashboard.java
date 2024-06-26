/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.iris.ui.travelagentadmin;

import com.iris.backend.controller.EnterpriseController;
import com.iris.backend.model.Catering;
import com.iris.backend.model.TravelAgent;
import com.iris.backend.model.User;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Aayuka Nirawade
 */
public class TravelAgentAdminDashboard extends javax.swing.JPanel {

    /**
     * Creates new form HotelAdminDashboard
     */
    
    ArrayList<User> userData;
    
    EnterpriseController enterpriseController;
    
    public TravelAgentAdminDashboard(ArrayList<User> userData) throws SQLException {
        initComponents();
        this.userData = userData;
        enterpriseController = new EnterpriseController();
        
        
        populateHotelData();
        disableFields();

    }
    
    private void populateHotelData() throws SQLException{

        ResultSet resultSet = enterpriseController.getEnterpriseData("TRAVEL", userData.get(0).getID());        
        TravelAgent hotelData = travelAgentMapper(resultSet);

//        jHotelPhoto.setIcon(icon);
        jHotelName.setText(hotelData.getTravelAgentName());
        jHotelAddress.setText(hotelData.getTravelAgentAddress());
        jHotelArea.setText(hotelData.getTravelAgentArea());
        jHotelCapacity.setText(hotelData.getCapacity());
        jHotelEmail.setText(hotelData.getEmail());
        jHotelPhone.setText(hotelData.getPhone());
//        String path = hotelData.getPhoto().replace("\\", "\\\\");
//        ImageIcon icon = new ImageIcon(path);    
//                jHotelPhoto.setIcon(icon);
    }
    
    private void disableFields(){
        jHotelName.setEnabled(false);
        jHotelAddress.setEnabled(false);
        jHotelArea.setEnabled(false);
        jHotelCapacity.setEnabled(false);
        jHotelEmail.setEnabled(false);
        jHotelPhone.setEnabled(false);
    }
    
    private TravelAgent travelAgentMapper(ResultSet resultSet) throws SQLException{
        TravelAgent travel = new TravelAgent();
        while(resultSet.next()){
           travel.setTravelAgentID(Integer.parseInt(resultSet.getString("TA_ID")));
            travel.setTravelAgentName(resultSet.getString("TA_NAME"));
            travel.setTravelAgentAddress(resultSet.getString("TA_ADDRESS"));
            travel.setTravelAgentArea(resultSet.getString("TA_AREA"));
            travel.setCapacity(resultSet.getString("TA_CAPACITY"));
            travel.setTravelAgentAdmin(resultSet.getString("TA_ADMIN"));
            travel.setBookedDates(resultSet.getString("TA_BOOKED_DATES"));
            travel.setPhoto(resultSet.getString("TA_PHOTO"));
            travel.setEmail(resultSet.getString("TA_EMAIL"));
            travel.setPhone(resultSet.getString("TA_PHONE"));
//            travel.setStatus(resultSet.getString("TA_STATUS"));
        }
        
        return travel; 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRoute = new javax.swing.JLabel();
        jHotelPhoto = new com.iris.ui.resources.ImageAvatar();
        jHotelName = new com.iris.ui.resources.TextField();
        jHotelAddress = new com.iris.ui.resources.TextField();
        jHotelArea = new com.iris.ui.resources.TextField();
        jHotelCapacity = new com.iris.ui.resources.TextField();
        jHotelEmail = new com.iris.ui.resources.TextField();
        jHotelPhone = new com.iris.ui.resources.TextField();

        setBackground(new java.awt.Color(245, 241, 241));

        jRoute.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jRoute.setForeground(new java.awt.Color(4, 72, 210));
        jRoute.setText("Admin / Dashboard");

        jHotelPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iris/ui/icons/hotel.png")));

        jHotelName.setLabelText("Hotel Name");
        jHotelName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHotelNameActionPerformed(evt);
            }
        });

        jHotelAddress.setLabelText("Address");

        jHotelArea.setLabelText("Area");

        jHotelCapacity.setLabelText("Capacity");

        jHotelEmail.setLabelText("Email");

        jHotelPhone.setLabelText("Phone");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jHotelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jHotelName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jHotelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jHotelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jHotelCapacity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jHotelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jHotelArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jRoute))
                .addContainerGap(305, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jHotelAddress, jHotelArea, jHotelCapacity, jHotelEmail, jHotelName, jHotelPhone});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jRoute)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jHotelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jHotelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHotelArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(jHotelCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jHotelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHotelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jHotelPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(253, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jHotelNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHotelNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jHotelNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.iris.ui.resources.TextField jHotelAddress;
    private com.iris.ui.resources.TextField jHotelArea;
    private com.iris.ui.resources.TextField jHotelCapacity;
    private com.iris.ui.resources.TextField jHotelEmail;
    private com.iris.ui.resources.TextField jHotelName;
    private com.iris.ui.resources.TextField jHotelPhone;
    private com.iris.ui.resources.ImageAvatar jHotelPhoto;
    private javax.swing.JLabel jRoute;
    // End of variables declaration//GEN-END:variables
}
