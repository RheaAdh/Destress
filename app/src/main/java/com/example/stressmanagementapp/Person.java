package com.example.stressmanagementapp;

public class Person {
    int Image;
    String Name;
    int time;
    int steps;
    String email;

    public Person(int image, String name, int time, int steps, String email) {
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
