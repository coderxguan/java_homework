package com.guanhf.trail2.a02;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Student> students = inputStudent();

        ArrayList<Course> courses = inputCourse();
        ArrayList<Result> results = handleData(students, courses);
        System.out.println("按学生统计:\n学号   姓名    性别    平均分");
        for (Student student : students) {
            System.out.print(student);
        }
        System.out.println("按课程统计:\n课程    平均分");
        for (Result result : results) {
            System.out.print(result);
        }
    }
    // 录入学生信息
    public static ArrayList<Student> inputStudent(){
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String info = sc.nextLine();
        while(!"end".equals(info)){
            String[] split = info.split(", ");
            String id = split[0];
            String name = split[1];
            String gender = split[2];
            Student student = new Student(id, name, gender);
            students.add(student);
            info = sc.nextLine();
        }
        return students;
    }


    // 录入课程信息
    public static ArrayList<Course> inputCourse(){
        ArrayList<Course> courses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();

        while(!"end".equals(info)){
            String[] split = info.split(", ");
            String id = split[0];
            String courseName = split[1];
            int score = Integer.parseInt(split[2]);
            Course course = new Course(id, courseName, score);
            courses.add(course);
            info = scanner.nextLine();
        }
        return courses;
    }

    // 处理信息, 生成结果
    public static ArrayList<Result> handleData(ArrayList<Student> students, ArrayList<Course> courses){
        ArrayList<Result> results = new ArrayList<>();
        int studentNum = students.size();
        //
        for (Course course : courses) {
            // 新建一个结果,
            Result result = new Result(course.getCourseName(),
                    ((double)course.getScore()/studentNum));
            int flag = 0;
            // 遍历结果集, 如果存在就加平均分
            for (Result r : results) {
                if(result.getCourseName().equals(r.getCourseName())){
                    r.setAvg(r.getAvg() + result.getAvg());
                    flag =1;
                }
            }
            // 不存在就将结果加入结果集
            if(flag == 0){
                results.add(result);
            }
        }
        // 算学生的平均分
        for (Student student : students) {
            int totalScore = 0;
            for (Course course : courses) {
                if(student.getId().equals(course.getId())){
                    totalScore += course.getScore();
                }
            }
            student.setAvg((double) totalScore /results.size());
        }
        return results;

    }
}
