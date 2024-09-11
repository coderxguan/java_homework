package com.guanhf.trail1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/11 21:35
 */
public class a04 {
    public static void main(String[] args) {
        int month, year;
        Scanner sc = new Scanner(System.in);
        month = sc.nextInt();
        year = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
        if(is_leap_year(year)){
            list.set(1, 29);
        }
        System.out.println(list.get(month-1));

    }
    public static boolean is_leap_year(int year){
        if(year%4 == 0 && year%100 != 0 || year%400 == 0){
            return true;
        }
        return false;
    }
}
