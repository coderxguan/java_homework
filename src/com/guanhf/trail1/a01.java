package com.guanhf.trail1;

import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/11 21:05
 */
public class a01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalMoney = sc.nextDouble();
        int total = (int)(totalMoney*1000);
        System.out.println(total);
        int integer = total/1000;
        int faction =  total%1000/10;

        int numOf10 = integer / 10 ;
        int numOf5 = (integer - numOf10 * 10) / 5;
        int numOf1 = integer - numOf5 * 5 - numOf10 * 10;

        int numOf50c = faction / 50;
        int numOf10c = (faction - numOf50c * 50  ) / 10;
        int numOf2c = (faction - numOf50c * 50 - numOf10c * 10 ) / 2;
        int numOf1c = (faction - numOf50c * 50 - numOf10c * 10 - numOf2c * 2);

        System.out.println(numOf10 + " 张十元");
        System.out.println(numOf5 + " 张五元");
        System.out.println(numOf1 + " 张一元");
        System.out.println(numOf50c + " 个五角");
        System.out.println(numOf10c + " 个一角");
        System.out.println(numOf2c + " 个贰分");
        System.out.println(numOf1c + " 个壹分");

    }
}
