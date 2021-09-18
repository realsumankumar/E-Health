package com.example.springauthenticateendpoint.model;


import java.sql.Date;
import java.sql.Time;


public class Availability {
    private int Id;
    private String physicianId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private boolean bookingStatus;


    public Availability(){

    }


    public Availability(String physicianId, Date date, Time startTime, Time endTime, boolean bookingStatus) {
        super();
        this.physicianId = physicianId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingStatus = bookingStatus;
    }


    public String getPhysicianId() {
        return physicianId;
    }


    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public Time getStartTime() {
        return startTime;
    }


    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }


    public Time getEndTime() {
        return endTime;
    }


    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }


    public boolean isBookingStatus() {
        return bookingStatus;
    }


    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }


}
