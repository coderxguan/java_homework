package com.guanhf.trail2.a04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        String stuFile = "src/com/guanhf/trail2/a04/stu.txt";
        ArrayList<Student> students = getStudentFromFile(stuFile);

        String courseFile = "src/com/guanhf/trail2/a04/course.txt";
        ArrayList<Course> courses = getCourseFromFile(courseFile);
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
    public static ArrayList<Student> getStudentFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        ArrayList<Student> students = new ArrayList<>();
        String info ="";
        while((info = br.readLine())!= null){
            String[] split = info.split("，");
            String id = split[0];
            String name = split[1];
            String gender = split[2];
            Student student = new Student(id, name, gender);
            students.add(student);
        }
        br.close();
        return students;
    }


    // 录入课程信息
    public static ArrayList<Course> getCourseFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        ArrayList<Course> courses = new ArrayList<>();
        String info = null;

        while((info = br.readLine())!=null){
            String[] split = info.split("，");
            String id = split[0];
            String courseName = split[1];
            int score = Integer.parseInt(split[2]);
            Course course = new Course(id, courseName, score);
            courses.add(course);
        }
        br.close();
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
