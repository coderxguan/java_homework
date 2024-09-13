package com.guanhf.trail1;

import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/13 17:21
 */
public class a15 {
    public static void main(String[] args) {

        int x, y, z;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();

        int years = 0;
        while (years < 100) {
            years++;
            int age1 = x + years;
            int age2 = y + years;
            int age3 = z + years;

            int lastDigit1 = age1 % 10;
            int lastDigit2 = age2 % 10;
            int lastDigit3 = age3 % 10;

            if ((lastDigit1 == 3 || lastDigit1 == 6 || lastDigit1 == 9) &&
                    (lastDigit2 == 3 || lastDigit2 == 6 || lastDigit2 == 9) &&
                    (lastDigit3 == 3 || lastDigit3 == 6 || lastDigit3 == 9) &&
                    (lastDigit1 != lastDigit2 && lastDigit1 != lastDigit3 && lastDigit2 != lastDigit3)) {
                System.out.println(years);
                return;
            }
        }
        System.out.println("so sad!");
    }
}
