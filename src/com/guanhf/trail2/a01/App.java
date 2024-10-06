package com.guanhf.trail2.a01;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/10/02 19:23
 */
public class App {
    public static void main(String[] args) {
        ArrayList<Student> students = inputStudent();
        ArrayList<Result> results = new ArrayList<>();
        int manNum = handleData(students, results);
        int womanNum = students.size() - manNum;
        double manRate = ((double) manNum /students.size())*100;
        double womanRate = ((double) womanNum /students.size())*100;

        System.out.println("程序处理结果如下:");
        System.out.println("总人数: " + students.size() + "人");
        System.out.println("其中男: " + manNum + "人, " + manRate + "%, 女: " + womanNum + "人, " + womanRate + "%");
        for (Result result : results) {
            System.out.print(result.getProvince() + ": " + result.getNum() + "人" + " (");
            for (String s : result.getName()) {
                if(result.getName().indexOf(s) == result.getName().size()-1){
                    System.out.print(s);
                }else{
                    System.out.print(s + ",");
                }
            }
            System.out.println(")");;
        }

    }

    public static ArrayList<Student> inputStudent() {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String info = scanner.nextLine();
        while(!"end".equals(info)) {
            // 分割处理数据
            String[] split = info.split(", ");
            String id = split[0];
            String name = split[1];
            String gender = split[2];
            String province = split[3];
            Student student = new Student(id, name, gender, province);
            students.add(student);
            info = scanner.nextLine();
        }
        return students;
    }

    public static int handleData(ArrayList<Student> students, ArrayList<Result> results) {
        int manNum = 0;
        for (Student student : students) {
            int flag = 0;
            if(student.getGender().equals("男")){
                manNum += 1;
            }
            for (Result result : results) {
                // 是男生则加一
                // 如果结果集中有对应省份, 则将数量加一, 名字加入集合
                if(student.getProvince().equals(result.getProvince())) {
                    result.setNum(result.getNum() + 1);
                    result.getName().add(student.getName());
                    flag = 1;
                }
            }
            if(flag == 0){
                ArrayList<String> name = new ArrayList<>();
                name.add(student.getName());
                results.add(new Result(student.getProvince(), 1, name));
            }
        }
        return manNum;
    }
}
