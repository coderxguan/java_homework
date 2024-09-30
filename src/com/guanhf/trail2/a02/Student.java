package com.guanhf.trail2.a02;

public class Student {
    private String id;
    private String name;
    private String gender;
    private double avg;

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public Student(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return id + "\t\t" + name + "\t\t" + gender + "\t\t" + avg + "\n";
    }
}
