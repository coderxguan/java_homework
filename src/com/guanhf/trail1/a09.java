package com.guanhf.trail1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/12 22:48
 */
public class a09 {
    public static void main(String[] args) {
        String line;
        Scanner sc = new Scanner(System.in);
        line = sc.nextLine();
        String[] s = line.split(" ");
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < s.length; i++) {
            try {
                sum += Integer.parseInt(s[i]);
            } catch (NumberFormatException e) {
                flag = true;
                continue;

            }
        }
        System.out.println(sum);
        if(flag){
            System.out.println("attention");
        }
    }
}
