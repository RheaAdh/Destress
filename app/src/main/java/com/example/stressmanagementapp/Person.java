package com.example.stressmanagementapp;

public class Person {
    int Image;
    String Name;
    String time;
    String steps;
    String email;

    public Person(int image, String name, String time, String steps, String email) {
        Image = image;
        Name = name;
        this.time = time;
        this.steps = steps;
        this.email = email;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
