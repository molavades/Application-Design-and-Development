/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.iris.ui.eventmanager;

import com.iris.backend.model.Catering;
import com.iris.backend.model.Event;
import com.iris.backend.model.Hotel;
import com.iris.backend.model.TravelAgent;
import com.iris.backend.model.User;
import com.iris.backend.model.WorkRequest;
import com.iris.backend.service.EnterpriseService;
import com.iris.backend.controller.WorkRequestController;
import com.iris.ui.resources.EmailConstants;
import com.iris.ui.resources.sendMail;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author sushanthkumarreddyjanga
 */
public class EventManagerRequests extends javax.swing.JPanel {

    /**
     * Creates new form EventManagerRequests
     */
    ArrayList<User> userData;
    ArrayList<Hotel> hList = new ArrayList<>();
    ArrayList<Hotel> hotelList = new ArrayList<>();
    ArrayList<Catering> cList = new ArrayList<>();
    ArrayList<TravelAgent> tList = new ArrayList<>();
    Event e;
    EnterpriseService enterpriseService;
    WorkRequestController workRequestController;
    sendMail sendMail;

    public EventManagerRequests(ArrayList<User> userData, Event e) throws SQLException {
        initComponents();
        this.userData = userData;
        this.e = e;
        enterpriseService = new EnterpriseService();
        workRequestController = new WorkRequestController();

        accoPanel.setVisible(false);
        caterPanel.setVisible(false);
        travelPanel.setVisible(false);

        accoStatus.setVisible(false);
        CaterStatus.setVisible(false);
        TravelStatus.setVisible(false);

        hList = enterpriseService.getAllHotelDataService();
        hotelList = enterpriseService.getAllHotelDataService();
        cList = enterpriseService.getAllCateringDataService();
        tList = enterpriseService.getAllTravelDataService();

        sendMail = new sendMail();
        
        if (e.getAccomodationNeeded().equalsIgnoreCase("yes")) {
            accoPanel.setVisible(true);
            populateAccoDropDown();
        }
        if (e.getFunctionHallNeeded().equalsIgnoreCase("yes")) {
            accoPanel.setVisible(true);
            populateAccoDropDown();
        }
        if (e.getCateringNeeded().equalsIgnoreCase("yes")) {
            caterPanel.setVisible(true);
            populateCaterDropDown();
        }
        if (e.getTravelNeeded().equalsIgnoreCase("yes")) {
            travelPanel.setVisible(true);
            populateTravelDropDown();
        }

    }

    public void populateAccoDropDown() throws SQLException {

        ArrayList<WorkRequest> workRequest = workRequestController.getAllWorkRequestData();
        int event_id = e.getEventID();
        int event_manager_id = e.getEventManagerID();

        for (WorkRequest wr : workRequest) {
            if (wr.getEventID() == event_id && wr.getEventManagerID() == event_manager_id) {
                if (wr.getType().equalsIgnoreCase("eventmanager_hoteladmin")) {
                    selectAcco.setVisible(false);
                    jLabel4.setVisible(false);
                    buttonAcco.setVisible(false);
                    accoStatus.setVisible(true);
                    accoStatus.setText(wr.getStatus());

                    // ArrayList<Hotel> hList = enterpriseService.getAllHotelDataService();
                    for (Hotel h : hList) {
                        if (Integer.parseInt(h.getHotelAdmin()) == (wr.getToID())) {
                            AccoName.setText(h.getHotelName());
                            AccoAddress.setText(h.getHotelAddress());
                        }
                    }

                    if (accoStatus.getText().equalsIgnoreCase("rejected")) {
                        accoStatus.setForeground(Color.red);

                        selectAcco.setVisible(true);
                        jLabel4.setVisible(true);
                        buttonAcco.setVisible(true);
                    } else if (accoStatus.getText().equalsIgnoreCase("accepted")) {
                        accoStatus.setForeground(Color.green);
                    } else if (accoStatus.getText().equalsIgnoreCase("pending")) {
                        accoStatus.setForeground(Color.orange);
                    }
                }
            }
        }
        ArrayList<String> hList = new ArrayList<>();
        hotelList.stream().forEach(hotel -> hList.add(hotel.getHotelName()));
        selectAcco.setModel(new DefaultComboBoxModel<>(hList.toArray(new String[0])));

        populateSelectedHotelDetail();
    }

    public void populateCaterDropDown() throws SQLException {

        ArrayList<WorkRequest> workRequest = workRequestController.getAllWorkRequestData();
        int event_id = e.getEventID();
        int event_manager_id = e.getEventManagerID();

        for (WorkRequest wr : workRequest) {
            if (wr.getEventID() == event_id && wr.getEventManagerID() == event_manager_id) {
                if (wr.getType().equalsIgnoreCase("eventmanager_cateringadmin")) {
                    selectCater.setVisible(false);
                    jLabel5.setVisible(false);
                    buttonCater.setVisible(false);
                    CaterStatus.setVisible(true);

                    CaterStatus.setText(wr.getStatus());
                    if (CaterStatus.getText().equalsIgnoreCase("rejected")) {
                        CaterStatus.setForeground(Color.red);

                        selectCater.setVisible(true);
                        jLabel5.setVisible(true);
                        buttonCater.setVisible(true);

                    } else if (CaterStatus.getText().equalsIgnoreCase("accepted")) {
                        CaterStatus.setForeground(Color.green);
                    } else if (CaterStatus.getText().equalsIgnoreCase("pending")) {
                        CaterStatus.setForeground(Color.orange);
                    }
                    for (Catering h : cList) {
                        if (Integer.parseInt(h.getCateringAdmin()) == (wr.getToID())) {
                            CaterName.setText(h.getCateringName());
                            CaterAddress.setText(h.getCateringAddress());
                        }
                    }
                }
            }
        }
        ArrayList<String> cater = new ArrayList<>();

        cList.stream().forEach(c -> cater.add(c.getCateringName()));
        selectCater.setModel(new DefaultComboBoxModel<>(cater.toArray(new String[0])));

        populateSelectedCaterDetail();
    }

    public void populateTravelDropDown() throws SQLException {

        ArrayList<WorkRequest> workRequest = workRequestController.getAllWorkRequestData();
        int event_id = e.getEventID();
        int event_manager_id = e.getEventManagerID();

        for (WorkRequest wr : workRequest) {
            if (wr.getEventID() == event_id && wr.getEventManagerID() == event_manager_id) {
                if (wr.getType().equalsIgnoreCase("eventmanager_travelagentadmin")) {
                    selectTravel.setVisible(false);
                    jLabel6.setVisible(false);
                    buttonTravel.setVisible(false);
                    selectTravel.setVisible(false);
                    TravelStatus.setVisible(true);

                    TravelStatus.setText(wr.getStatus());
                    if (TravelStatus.getText().equalsIgnoreCase("rejected")) {
                        TravelStatus.setForeground(Color.red);
                        jLabel6.setVisible(true);
                        buttonTravel.setVisible(true);
                        selectTravel.setVisible(true);
                    } else if (TravelStatus.getText().equalsIgnoreCase("accepted")) {
                        TravelStatus.setForeground(Color.green);
                    } else if (TravelStatus.getText().equalsIgnoreCase("pending")) {
                        TravelStatus.setForeground(Color.ORANGE);
                    }

                    for (TravelAgent h : tList) {
                        if (Integer.parseInt(h.getTravelAgentAdmin()) == (wr.getToID())) {
                            TAName.setText(h.getTravelAgentName());
                            TAAddress.setText(h.getTravelAgentAddress());
                        }
                    }
                }
            }
        }
        ArrayList<String> travelList = new ArrayList<>();

        tList.stream().forEach(t -> travelList.add(t.getTravelAgentName()));
        selectTravel.setModel(new DefaultComboBoxModel<>(travelList.toArray(new String[0])));

        populateSelectedTravelAgent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLocation2 = new javax.swing.JLabel();
        accoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selectAcco = new javax.swing.JComboBox<>();
        buttonAcco = new com.iris.ui.resources.Button();
        AccoName = new com.iris.ui.resources.TextField();
        AccoAddress = new com.iris.ui.resources.TextField();
        accoStatus = new javax.swing.JLabel();
        AccoCapacity = new com.iris.ui.resources.TextField();
        AccoBookDts = new com.iris.ui.resources.TextField();
        caterPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selectCater = new javax.swing.JComboBox<>();
        buttonCater = new com.iris.ui.resources.Button();
        CaterStatus = new javax.swing.JLabel();
        CaterName = new com.iris.ui.resources.TextField();
        CaterAddress = new com.iris.ui.resources.TextField();
        CaterCapacity = new com.iris.ui.resources.TextField();
        CaterBookDts = new com.iris.ui.resources.TextField();
        travelPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        selectTravel = new javax.swing.JComboBox<>();
        buttonTravel = new com.iris.ui.resources.Button();
        TravelStatus = new javax.swing.JLabel();
        TAName = new com.iris.ui.resources.TextField();
        TAAddress = new com.iris.ui.resources.TextField();
        TANameBookDts = new com.iris.ui.resources.TextField();
        TANameCapacity = new com.iris.ui.resources.TextField();

        setBackground(new java.awt.Color(245, 241, 241));
        setAutoscrolls(true);
        setMaximumSize(new java.awt.Dimension(1196, 720));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jLocation2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLocation2.setForeground(new java.awt.Color(4, 72, 210));
        jLocation2.setText("Event Manager / Request");

        accoPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setText("Accomodation");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setText("Select a hotel");

        selectAcco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectAcco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAccoActionPerformed(evt);
            }
        });

        buttonAcco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttonAcco.setText("REQUEST");
        buttonAcco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAccoActionPerformed(evt);
            }
        });

        AccoName.setEditable(false);
        AccoName.setLabelText("Hotel Name");

        AccoAddress.setEditable(false);
        AccoAddress.setLabelText("Hotel Address");

        accoStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accoStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AccoCapacity.setEditable(false);
        AccoCapacity.setLabelText("Hotel Capacity");

        AccoBookDts.setEditable(false);
        AccoBookDts.setLabelText("Hotel Booked Dates");

        javax.swing.GroupLayout accoPanelLayout = new javax.swing.GroupLayout(accoPanel);
        accoPanel.setLayout(accoPanelLayout);
        accoPanelLayout.setHorizontalGroup(
            accoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accoPanelLayout.createSequentialGroup()
                .addGroup(accoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(accoPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(accoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonAcco, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(31, 31, 31)
                        .addGroup(accoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectAcco, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(accoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accoPanelLayout.createSequentialGroup()
                        .addComponent(AccoAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AccoName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(accoPanelLayout.createSequentialGroup()
                        .addComponent(AccoCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AccoBookDts, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        accoPanelLayout.setVerticalGroup(
            accoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accoPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(accoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AccoCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AccoBookDts, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(accoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AccoAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AccoName, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(accoPanelLayout.createSequentialGroup()
                        .addGroup(accoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(accoPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(accoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(accoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(accoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(selectAcco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(buttonAcco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45))))
        );

        caterPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("Catering");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setText("Select a caterer");

        selectCater.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectCater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCaterActionPerformed(evt);
            }
        });

        buttonCater.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttonCater.setText("REQUEST");
        buttonCater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCaterActionPerformed(evt);
            }
        });

        CaterStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CaterStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CaterName.setEditable(false);
        CaterName.setLabelText("Cater Name");

        CaterAddress.setEditable(false);
        CaterAddress.setLabelText("Cater Address");

        CaterCapacity.setEditable(false);
        CaterCapacity.setLabelText("Cater Capacity");

        CaterBookDts.setEditable(false);
        CaterBookDts.setLabelText("Cater Booked Dates");

        javax.swing.GroupLayout caterPanelLayout = new javax.swing.GroupLayout(caterPanel);
        caterPanel.setLayout(caterPanelLayout);
        caterPanelLayout.setHorizontalGroup(
            caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caterPanelLayout.createSequentialGroup()
                .addGroup(caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(caterPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(caterPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(buttonCater, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectCater, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CaterStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CaterName, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(CaterAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CaterCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(CaterBookDts, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))
                .addGap(122, 122, 122))
        );
        caterPanelLayout.setVerticalGroup(
            caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, caterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(caterPanelLayout.createSequentialGroup()
                        .addGroup(caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CaterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CaterCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CaterAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CaterBookDts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(caterPanelLayout.createSequentialGroup()
                        .addGroup(caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(selectCater, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(caterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonCater, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CaterStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );

        travelPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("Travel");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setText("Select an agent");

        selectTravel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectTravel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTravelActionPerformed(evt);
            }
        });

        buttonTravel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttonTravel.setText("REQUEST");
        buttonTravel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTravelActionPerformed(evt);
            }
        });

        TravelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TravelStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TAName.setEditable(false);
        TAName.setLabelText("Travel Agent Name");

        TAAddress.setEditable(false);
        TAAddress.setLabelText("Travel Agent Address");

        TANameBookDts.setEditable(false);
        TANameBookDts.setLabelText("Travel Booked Dates");

        TANameCapacity.setEditable(false);
        TANameCapacity.setLabelText("Travel Agent Capacity");

        javax.swing.GroupLayout travelPanelLayout = new javax.swing.GroupLayout(travelPanel);
        travelPanel.setLayout(travelPanelLayout);
        travelPanelLayout.setHorizontalGroup(
            travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(travelPanelLayout.createSequentialGroup()
                .addGroup(travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(travelPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(buttonTravel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectTravel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TravelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TAName, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(TAAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TANameBookDts, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(TANameCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                    .addGroup(travelPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(119, 119, 119))
        );
        travelPanelLayout.setVerticalGroup(
            travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(travelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(travelPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TAName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TANameCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TAAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TANameBookDts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(travelPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(selectTravel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(travelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TravelStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonTravel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLocation2)
                    .addComponent(accoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(caterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(travelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLocation2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(caterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(travelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCaterActionPerformed
        String catering = selectCater.getSelectedItem().toString();

        ArrayList<Catering> cList;
        try {
            cList = enterpriseService.getAllCateringDataService();
            for (Catering c : cList) {
                if (c.getCateringName().equalsIgnoreCase(catering)) {
                    String ca_id = c.getCateringAdmin();
                    WorkRequest wr = new WorkRequest();
                    int event_manager_id = e.getEventManagerID();
                    int event_id = e.getEventID();
                    wr.setID(workRequestController.getAllWorkRequestData().size() + 1);
                    wr.setType("EVENTMANAGER_CATERINGADMIN");
                    wr.setFromID(event_manager_id);
                    wr.setToID(Integer.parseInt(ca_id));
                    wr.setStatus("PENDING");
                    wr.setEventID(event_id);
                    wr.setEventManagerID(event_manager_id);
                    workRequestController.createWorkRequest(wr);

                    JOptionPane.showMessageDialog(this, "Request sent to catering admin!");
                    selectCater.setVisible(false);
                    jLabel5.setVisible(false);
                    buttonCater.setVisible(false);
                    CaterStatus.setVisible(true);

                    CaterStatus.setText("PENDING");
                    CaterStatus.setForeground(Color.ORANGE);
                    CaterName.setText(c.getCateringName());
                    CaterAddress.setText(c.getCateringAddress());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventManagerRequests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonCaterActionPerformed

    private void buttonTravelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTravelActionPerformed
        String travel = selectTravel.getSelectedItem().toString();

        ArrayList<TravelAgent> tList;
        try {
            tList = enterpriseService.getAllTravelDataService();
            for (TravelAgent t : tList) {
                if (t.getTravelAgentName().equalsIgnoreCase(travel)) {
//                int hotel_id = h.getHotelID();
                    String ta_id = t.getTravelAgentAdmin();
                    WorkRequest wr = new WorkRequest();
                    int event_manager_id = e.getEventManagerID();
                    int event_id = e.getEventID();
                    wr.setID(workRequestController.getAllWorkRequestData().size() + 1);
                    wr.setType("EVENTMANAGER_TRAVELAGENTADMIN");
                    wr.setFromID(event_manager_id);
                    wr.setToID(Integer.parseInt(ta_id));
                    wr.setStatus("PENDING");
                    wr.setEventID(event_id);
                    wr.setEventManagerID(event_manager_id);
                    workRequestController.createWorkRequest(wr);

                    JOptionPane.showMessageDialog(this, "Request sent to travel agent admin!");
                    selectTravel.setVisible(false);
                    jLabel6.setVisible(false);
                    buttonTravel.setVisible(false);
                    TravelStatus.setVisible(true);

                    TravelStatus.setText("PENDING");
                    TravelStatus.setForeground(Color.ORANGE);

                    TAName.setText(t.getTravelAgentName());
                    TAAddress.setText(t.getTravelAgentAddress());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventManagerRequests.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_buttonTravelActionPerformed

    private void buttonAccoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAccoActionPerformed
        String hotel = selectAcco.getSelectedItem().toString();

        ArrayList<Hotel> hotelList;
        try {
            hotelList = enterpriseService.getAllHotelDataService();
            for (Hotel h : hotelList) {
                if (h.getHotelName().equalsIgnoreCase(hotel)) {
                    //                int hotel_id = h.getHotelID();
                    String ha_id = h.getHotelAdmin();
                    WorkRequest wr = new WorkRequest();
                    int event_manager_id = e.getEventManagerID();
                    int event_id = e.getEventID();
                    wr.setID(workRequestController.getAllWorkRequestData().size() + 1);
                    wr.setType("EVENTMANAGER_HOTELADMIN");
                    wr.setFromID(event_manager_id);
                    wr.setToID(Integer.parseInt(ha_id));
                    wr.setStatus("PENDING");
                    wr.setEventID(event_id);
                    wr.setEventManagerID(event_manager_id);
                    workRequestController.createWorkRequest(wr);

                    JOptionPane.showMessageDialog(this, "Request sent to hotel admin!");
                    selectAcco.setVisible(false);
                    jLabel4.setVisible(false);
                    buttonAcco.setVisible(false);
                    accoStatus.setVisible(true);
                    accoStatus.setText("PENDING");
                    accoStatus.setForeground(Color.orange);
                    AccoName.setText(h.getHotelName());
                    AccoAddress.setText(h.getHotelAddress());
                    
//                    sendMail.sendEmailFunction(eventEmailId, 
//                    EmailConstants.USER_EVENT_ASSIGN_MANAGER_SUBJECT, 
//                    EmailConstants.USER_EVENT_ASSIGN_MANAGER_TEXT);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventManagerRequests.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buttonAccoActionPerformed

    private void selectAccoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAccoActionPerformed
        // TODO add your handling code here:
        populateSelectedHotelDetail();
    }//GEN-LAST:event_selectAccoActionPerformed

    private void populateSelectedHotelDetail() {
        if (selectAcco.getSelectedItem() != null) {
            String hName = selectAcco.getSelectedItem().toString();
            if (!hotelList.isEmpty()) {
                for (Hotel hotel : hotelList) {
                    if (hName.equalsIgnoreCase(hotel.getHotelName())) {
                        AccoName.setText(hotel.getHotelName());
                        AccoAddress.setText(hotel.getHotelAddress());
                        AccoCapacity.setText(hotel.getCapacity());
                        AccoBookDts.setText(hotel.getBookedDates());
                    }
                }
            }
        }
    }

    private void selectCaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCaterActionPerformed
        // TODO add your handling code here:
        populateSelectedCaterDetail();
    }//GEN-LAST:event_selectCaterActionPerformed

    private void populateSelectedCaterDetail() {
        if (selectCater.getSelectedItem() != null) {
            String cName = selectCater.getSelectedItem().toString();
            if (!cList.isEmpty()) {
                for (Catering catr : cList) {
                    if (catr.getCateringName().equalsIgnoreCase(cName)) {
                        CaterName.setText(cName);
                        CaterAddress.setText(catr.getCateringAddress());
                        CaterCapacity.setText(catr.getCapacity());
                        CaterBookDts.setText(catr.getBookedDates() != null ? catr.getBookedDates() : "");
                    }
                }
            }
        }
    }

    private void selectTravelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTravelActionPerformed
        // TODO add your handling code here:
        populateSelectedTravelAgent();
    }//GEN-LAST:event_selectTravelActionPerformed

    private void populateSelectedTravelAgent() {
        if (selectTravel.getSelectedItem() != null) {
            String tName = selectTravel.getSelectedItem().toString();
            if (!tList.isEmpty()) {
                for (TravelAgent trvlAgnt : tList) {
                    if (trvlAgnt.getTravelAgentName().equalsIgnoreCase(tName)) {
                        TAName.setText(tName);
                        TAAddress.setText(trvlAgnt.getTravelAgentAddress());
                        TANameCapacity.setText(trvlAgnt.getCapacity());
                        TANameBookDts.setText(trvlAgnt.getBookedDates() != null ? trvlAgnt.getBookedDates() : "");
                    }
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.iris.ui.resources.TextField AccoAddress;
    private com.iris.ui.resources.TextField AccoBookDts;
    private com.iris.ui.resources.TextField AccoCapacity;
    private com.iris.ui.resources.TextField AccoName;
    private com.iris.ui.resources.TextField CaterAddress;
    private com.iris.ui.resources.TextField CaterBookDts;
    private com.iris.ui.resources.TextField CaterCapacity;
    private com.iris.ui.resources.TextField CaterName;
    private javax.swing.JLabel CaterStatus;
    private com.iris.ui.resources.TextField TAAddress;
    private com.iris.ui.resources.TextField TAName;
    private com.iris.ui.resources.TextField TANameBookDts;
    private com.iris.ui.resources.TextField TANameCapacity;
    private javax.swing.JLabel TravelStatus;
    private javax.swing.JPanel accoPanel;
    private javax.swing.JLabel accoStatus;
    private com.iris.ui.resources.Button buttonAcco;
    private com.iris.ui.resources.Button buttonCater;
    private com.iris.ui.resources.Button buttonTravel;
    private javax.swing.JPanel caterPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLocation2;
    private javax.swing.JComboBox<String> selectAcco;
    private javax.swing.JComboBox<String> selectCater;
    private javax.swing.JComboBox<String> selectTravel;
    private javax.swing.JPanel travelPanel;
    // End of variables declaration//GEN-END:variables
}
