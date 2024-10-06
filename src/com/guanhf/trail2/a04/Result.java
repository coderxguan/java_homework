package com.guanhf.trail2.a04;

public class Result {
    private String courseName;
    private double avg;

    public Result(String courseName, double avg) {
        this.courseName = courseName;
        this.avg = avg;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return courseName + "\t" + (int)avg + "\n";
    }
}
