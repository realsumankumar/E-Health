package com.example.springauthenticateendpoint.model;

import java.sql.Date;
import java.sql.Time;

public class LabRecord {
    private String testId;
    private String treatmentId;
    private String testName;
    private String physicianId;
    private String patientId;
    private Date date;
    private Time time;


    public LabRecord() {
    }


    public LabRecord(String treatmentId, String testName, String physicianId, String patientId,
                     Date date, Time time) {
        super();
        this.treatmentId = treatmentId;
        this.testName = testName;
        this.physicianId = physicianId;
        this.patientId = patientId;
        this.date = date;
        this.time = time;
    }


    public String getTestId() {
        return testId;
    }


    public void setTestId(String testId) {
        this.testId = testId;
    }


    public String getTreatmentId() {
        return treatmentId;
    }


    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }


    public String getTestName() {
        return testName;
    }


    public void setTestName(String testName) {
        this.testName = testName;
    }


    public String getPhysicianId() {
        return physicianId;
    }


    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }


    public String getPatientId() {
        return patientId;
    }


    public void setPatientId(String patientId) {
        this.patientId = patientId;
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