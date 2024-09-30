package com.guanhf.trail2.a02;

public class Course {
    private String id;
    private String courseName;
    private int score;

    public Course(String id, String courseName, int score) {
        this.id = id;
        this.courseName = courseName;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", score=" + score +
                '}';
    }
}
