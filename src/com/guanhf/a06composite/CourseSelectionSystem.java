package com.guanhf.a06composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/15 10:35
 */
// 学生类
class Student {
    String Id;
    String name;

    public Student(String studentId, String name) {
        this.Id = studentId;
        this.name = name;
    }
}
// 课程类
class Course {
    String academicYear;
    String semester;
    String courseCode;
    String courseName;
    int maxStudents;
    List<Student> enrolledStudents;

    public Course(String academicYear, String semester, String courseCode, String courseName, int maxStudents) {
        this.academicYear = academicYear;
        this.semester = semester;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxStudents = maxStudents;
        this.enrolledStudents = new ArrayList<>();
    }

    public boolean enroll(Student student) {
        if (enrolledStudents.size() < maxStudents) {
            enrolledStudents.add(student);
            return true;
        } else {
            return false;
        }
    }

    public void printEnrollment() {
        System.out.println("学年：" + academicYear + "    学期：" + semester);
        System.out.println("课程代码：" + courseCode + "  课程名称：" + courseName);
        System.out.println("共有" + enrolledStudents.size() + "人选课，名单如下：");
        System.out.println("序号     学号   姓名");
        System.out.println("======================");
        for (int i = 0; i < enrolledStudents.size(); i++) {
            Student s = enrolledStudents.get(i);
            System.out.println( (i + 1) +"      "+ s.Id +"    "+ s.name);
        }
    }
}

// 选课系统
public class CourseSelectionSystem {
    private List<Course> courses;

    public CourseSelectionSystem() {
        courses = new ArrayList<>();
    }

    public void createCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入学年：");
        String academicYear = scanner.nextLine();
        System.out.print("输入学期：");
        String semester = scanner.nextLine();
        System.out.print("输入课程代码：");
        String courseCode = scanner.nextLine();
        System.out.print("输入课程名称：");
        String courseName = scanner.nextLine();
        System.out.print("输入课程最大人数：");
        int maxStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Course course = new Course(academicYear, semester, courseCode, courseName, maxStudents);
        courses.add(course);
        System.out.println("课程创建成功！");
    }

    public void enrollStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入课程代码：");
        String courseCode = scanner.nextLine();
        Course course = findCourse(courseCode);

        if (course == null) {
            System.out.println("课程不存在！");
        } else {
            if (course.enrolledStudents.size() >= course.maxStudents) {
                System.out.println("课程已满，无法选课！");
            } else {
                System.out.print("输入学生学号：");
                String studentId = scanner.nextLine();
                System.out.print("输入学生姓名：");
                String name = scanner.nextLine();
                Student student = new Student(studentId, name);

                if (course.enroll(student)) {
                    System.out.println("选课成功！");
                } else {
                    System.out.println("选课失败！");
                }
            }
        }
    }

    public void printEnrollment() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入课程代码：");
        String courseCode = scanner.nextLine();
        Course course = findCourse(courseCode);

        if (course == null) {
            System.out.println("课程不存在！");
        } else {
            course.printEnrollment();
        }
    }

    private Course findCourse(String courseCode) {
        for (Course c : courses) {
            if (c.courseCode.equals(courseCode)) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CourseSelectionSystem system = new CourseSelectionSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("WTU选课系统");
            System.out.println("1. 创建课程");
            System.out.println("2. 学生选课");
            System.out.println("3. 打印名单");
            System.out.println("4. 退出");
            System.out.print("请选择（1-4）：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    system.createCourse();
                    break;
                case 2:
                    system.enrollStudent();
                    break;
                case 3:
                    system.printEnrollment();
                    break;
                case 4:
                    running = false;
                    System.out.println("系统已退出。");
                    break;
                default:
                    System.out.println("无效选择，请重新输入。");
            }
        }
        scanner.close();
    }
}
