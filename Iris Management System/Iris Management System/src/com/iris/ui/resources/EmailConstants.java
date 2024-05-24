/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iris.ui.resources;

/**
 *
 * @author harsh
 */
public class EmailConstants {

    public static final String USER_EVENT_CREATE_SUBJECT = "Thanks for creating an Event";
    public static final String USER_EVENT_CREATE_TEXT = new StringBuilder("New event has been created successfully.")
            .append(" Kindy wait until a Manager has been assigned to you. ")
            .append(" You will receive a callback soon!").toString();
    
    
    public static final String USER_EVENT_ASSIGN_MANAGER_SUBJECT = "Evemt Manger has been Assigned to the Event.";
    public static final String USER_EVENT_ASSIGN_MANAGER_TEXT = new StringBuilder("Hi User ,")
            .append(" An Event Manger has been assigned to the Event that was created by you. ")
            .append(" Please login to the application and proceed further !").toString();
    
    public static final String USER_EVENT_MANAGER_HOTEL_REQUEST_SUBJECT = "Evemt Manger has placed Accomoditaion request to the Event.";
    public static final String USER_EVENT_MANAGER_HOTEL_REQUEST_TEXT = new StringBuilder("Hi User ,")
            .append(" An Event Manger has been assigned to the Event that was created by you. ")
            .append(" And the Event manger had places a request for the Accomidation/ Function Hall to the Event. ")
            .append(" Please login to the application and proceed further !").toString();

    public static final String USER_EVENT_MANAGER_CATERER_REQUEST_SUBJECT = "Evemt Manger has placed Caterer request to the Event.";
    public static final String USER_EVENT_MANAGER_CATERER_REQUEST_TEXT = new StringBuilder("Hi User ,")
            .append(" An Event Manger has been assigned to the Event that was created by you. ")
            .append(" And the Event manger had places a request for the Caterer to the Event. ")
            .append(" Please login to the application and proceed further !").toString();
    
    public static final String USER_EVENT_MANAGER_TRAVEL_REQUEST_SUBJECT = "Evemt Manger has placed Travel Agent reqeust to the Event.";
    public static final String USER_EVENT_MANAGER_TRAVEL_REQUEST_TEXT = new StringBuilder("Hi User ,")
            .append(" An Event Manger has been assigned to the Event that was created by you. ")
            .append(" And the Event manger had places a request for the Travel Agent to the Event. ")
            .append(" Please login to the application and proceed further !").toString();
}
