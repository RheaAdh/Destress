package com.example.stressmanagementapp.models;

import java.util.Date;

public class PatientRecord {
    String meditationLength;
    String stepCount;
    Person p;
    Date dateTime;

    public PatientRecord(){

    }

    public PatientRecord(String meditationLength, String stepCount, Person p, Date dateTime) {
        this.meditationLength = meditationLength;
        this.stepCount = stepCount;
        this.p = p;
        this.dateTime = dateTime;
    }

    public String getMeditationLength() {
        return meditationLength;
    }

    public void setMeditationLength(String meditationLength) {
        this.meditationLength = meditationLength;
    }

    public String getStepCount() {
        return stepCount;
    }

    public void setStepCount(String stepCount) {
        this.stepCount = stepCount;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
