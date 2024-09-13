package com.guanhf.a05;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/13 16:43
 */
public class StudentTest {
    public static void main(String[] args) {

        Student s1 = new Student("tom1", "111", "001");
        Student s2 = new Student("tom2", "222", "002");

        System.out.println(s1.displayStudent());
        System.out.println(s2.displayStudent());
    }
}
