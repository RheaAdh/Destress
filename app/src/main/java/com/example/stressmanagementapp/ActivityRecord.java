package com.example.stressmanagementapp;

public class ActivityRecord {
    String time;
    String steps;
    Person p;

    public ActivityRecord(String time, String steps, Person p) {
        this.time = time;
        this.steps = steps;
        this.p = p;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }
}
