package com.example.stressmanagementapp.models;

import java.util.Date;

public class PatientRecord {
    String meditateTime;
    String stepCount;
    String email;
    String dateTime;

    public PatientRecord(){

    }

    public PatientRecord(String meditateTime, String stepCount, String email, String dateTime) {
        this.meditateTime = meditateTime;
        this.stepCount = stepCount;
        this.email = email;
        this.dateTime = dateTime;
    }

    public String getMeditateTime() {
        return meditateTime;
    }

    public void setMeditateTime(String meditateTime) {
        this.meditateTime = meditateTime;
    }

    public String getStepCount() {
        return stepCount;
    }

    public void setStepCount(String stepCount) {
        this.stepCount = stepCount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
