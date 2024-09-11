package com.guanhf.trail1;

import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/11 22:36
 */
public class a08 {
    public static void main(String[] args) {
        int row;
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();

        for (int i = 0; i < row; i++) {
            int w = row - i - 1;
            while(w!=0) {
                System.out.print(" ");
                w--;
            }
            int star = 2*i+1;
            while(star!=0) {
                System.out.print("*");
                star--;
            }
            System.out.println();
        }
    }
}
