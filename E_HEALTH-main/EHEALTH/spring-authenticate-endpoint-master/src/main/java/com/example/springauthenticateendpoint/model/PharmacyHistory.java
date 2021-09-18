package com.example.springauthenticateendpoint.model;

import java.sql.Date;
import java.sql.Time;


public class PharmacyHistory {
    private String id;
    private String treatmentId;
    private String patientId;
    private String physicianId;
    private String prescription;
    private String medicines;
    private Date date;
    private Time time;
    
   

    public PharmacyHistory() {
    }

    public PharmacyHistory(String id, String treatmentId, String patientId, String physicianId, String prescription, String medicines, Date date, Time time) {
        this.id = id;
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.physicianId = physicianId;
        this.prescription = prescription;
        this.medicines = medicines;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
