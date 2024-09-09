package com.guanhf.a03;
/*
Create a Java program to input 5 student results as a numeric grade (0-100).
If a grade entered is less than 0 or greater than 100 ask for re-entry
of that particular grade. Your program is to calculate and display the
class average grade and also display the highest and lowest grades when the
appropriate menu option is chosen.
Check function is added after completion. When the user does not enter the score,
if other functions are selected, a prompt "please enter the score first and then " +
"execute the function" will be given, and the main menu will be returned.
*/

import java.awt.*;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double [] grade = new double[5];
        boolean flag = true;
        while (flag)
        {
            Homework01 homework01 = new Homework01();
            int select = homework01.showMenu();
            switch (select) {
                case 1 -> {
                    homework01.EnterResults(grade);
                }
                case 2 -> {
                    if (grade[0] == 0) {
                        System.out.println("please enter the score first and then execute the function");
                    } else {
                        homework01.Average(grade);
                    }
                }
                case 3 -> {
                    if (grade[0] == 0) {
                        System.out.println("please enter the score first and then execute the function");
                    } else {
                        homework01.HighestGrade(grade);
                    }
                }
                case 4 -> {
                    if (grade[0] == 0) {
                        System.out.println("please enter the score first and then execute the function");
                    } else {
                        homework01.LowestGrade(grade);
                    }
                }
                case 5 -> {
                    if (grade[0] == 0) {
                        System.out.println("please enter the score first and then execute the function");
                    } else {
                        homework01.GradeSort(grade);
                    }
                }
                default -> {
                    System.out.println("Are you sure exiting? (y or n): ");
                    if(scanner.next().equalsIgnoreCase("y")){
                        flag = false;
                    }
                }
            }
        }
    }


    public int showMenu(){
        System.out.println("1. Enter Student Results");
        System.out.println("2. Class Average");
        System.out.println("3. Highest Grade");
        System.out.println("4. Lowest Grade");
        System.out.println("5. Grade Sort");
        System.out.println("6. Exit");
        int select;
        Scanner scanner = new Scanner(System.in);
        select = scanner.nextInt();
        return select;
    }

    public void EnterResults(double [] grade){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < grade.length; i++) {
            System.out.println("input the " + (i + 1) + " score: ");
            double score = scanner.nextDouble();
            // invalid input
            if(score <= 0 || score > 100){
                System.out.println("invalid input please retry!");
                i --;
            }else {
                grade[i] = score;
            }
        }
        System.out.println("input successfully");
    }
    public void Average(double [] grade){
        double sum = 0;
        for (int i = 0; i < grade.length; i++) {
            sum += grade[i];
        }
        System.out.println("the average grade : " + (sum / grade.length));
    }

    public void HighestGrade(double [] grade){
        double highest = grade[0];
        for (int i = 1; i < grade.length; i++) {
            if (grade[i] > highest) {
                highest = grade[i];
            }
        }
        System.out.println("the highest grade : " + highest);

    }
    public void LowestGrade(double [] grade) {
        double lowest = grade[0];
        for (int i = 1; i < grade.length; i++) {
            if (grade[i] < lowest) {
                lowest = grade[i];
            }
        }
        System.out.println("the lowest grade : " + lowest);
    }
    public void GradeSort(double [] grade){
        Arrays.sort(grade);
        System.out.println("Sorted grades: " + Arrays.toString(grade));

    }

}
