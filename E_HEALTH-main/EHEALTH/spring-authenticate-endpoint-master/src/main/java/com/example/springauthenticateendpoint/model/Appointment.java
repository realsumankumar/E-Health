package com.example.springauthenticateendpoint.model;


import java.sql.Date;
import java.sql.Time;

public class Appointment {

    private String appointmentId;
    private String physicianId;
    private String patientId;
    private Date date;
    private Time time;

    public Appointment() {
    }

    public Appointment(String appointmentId, String physicianId, String patientId, Date date, Time time) {
        this.appointmentId = appointmentId;
        this.physicianId = physicianId;
        this.patientId = patientId;
        this.date = date;
        this.time = time;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointment_id) {
        this.appointmentId = appointment_id;
    }

    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physician_id) {
        this.physicianId = physician_id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patient_id) {
        this.patientId = patient_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}

