package com.guanhf.trail1;

import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/11 21:31
 */
public class a03 {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        int ab2 = a*a + b*b;
        double ab = Math.pow(ab2, 0.5);
        if(ab <= 10){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }
}
