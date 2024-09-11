package com.guanhf.trail1;

import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/11 21:27
 */
public class a02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tribe = sc.nextInt();
        int sum = 0;
        while (tribe != 0) {
            int tmp = tribe%10;
            sum += tmp;
            tribe /= 10;
        }

        System.out.println(sum);
    }
}
