package com.guanhf.trail1;

import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/13 17:38
 */
public class a17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if (age >= 0 && age <= 9) {
            System.out.println("垂髫之年");
        } else if (age >= 10 && age <= 19) {
            System.out.println("志学之年");
        } else if (age >= 20 && age <= 29) {
            System.out.println("弱冠之年");
        } else if (age >= 30 && age <= 39) {
            System.out.println("而立之年");
        } else if (age >= 40 && age <= 49) {
            System.out.println("不惑之年");
        } else if (age >= 50 && age <= 59) {
            System.out.println("知命之年");
        } else if (age >= 60 && age <= 69) {
            System.out.println("花甲之年");
        } else if (age >= 70 && age <= 79) {
            System.out.println("古稀之年");
        } else if (age >= 80 && age <= 89) {
            System.out.println("杖朝之年");
        } else if (age >= 90 && age <= 99) {
            System.out.println("耄耋之年");
        }
    }
}
