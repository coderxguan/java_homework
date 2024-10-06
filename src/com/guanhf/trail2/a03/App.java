package com.guanhf.trail2.a03;


import java.io.*;
import java.util.ArrayList;

/**
 * 功能:
 * 作者:
 * 日期:2024/10/06 18:39
 */
public class App {
    public static void main(String[] args) throws IOException {
        String fileName = "src/com/guanhf/trail2/a03/stu.txt";
        readFile(fileName);
        ArrayList<Student> students = readFile(fileName);
        ArrayList<Result> results = new ArrayList<>();
        int manNum = process(students, results);
        int womanNum = students.size() - manNum;
        double manRate = ((double) manNum /students.size())*100;
        double womanRate = ((double) womanNum /students.size())*100;
        // 四舍五入保留一位小数
        manRate = Math.round(manRate * 10.0) / 10.0;
        womanRate = Math.round(womanRate * 10.0) / 10.0;

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

    public static ArrayList<Student> readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        ArrayList<Student> students = new ArrayList<>();
        String line = null;
        while ((line = br.readLine())!=null){
            String[] split = line.split("，");
            String id = split[0];
            String name = split[1];
            String gender = split[2];
            String province = split[3];
            Student student = new Student(id, name, gender, province);
            students.add(student);
        }
        br.close();
        return students;
    }

    public static int process(ArrayList<Student> students, ArrayList<Result> results) {
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
