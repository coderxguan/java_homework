package com.guanhf.trail1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/12 23:00
 */
public class a10 {
    public static void main(String[] args) {
        int m, n, r;
        Scanner sc = new Scanner(System.in);
        try {
            m = sc.nextInt();
            n = sc.nextInt();
            r = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("data type error");
            return;
        }
        if(r != 90 && r != 180 && r != -90){
            System.out.println("angle data error");
            return;
        }
        // init array
        int [][] data = new int [m][n];
        // input data
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int tmp = 0;
                try {
                    tmp = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("data type error");
                    return;
                }
                if(tmp < 0 || tmp > 255){
                    System.out.println("matrix data error");
                    return;
                }
                data[i][j] = tmp;
            }
        }

        if(r == 90){
            for(int i = n - 1; i >= 0; i--){
                for(int j = 0; j < m; j++){
                    System.out.print(data[j][i]);
                    if(j < m -1){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }else if(r == 180){
            // a[2][3]  a[2][2] a[2][1] a[2][0]
            // a[m-1][n-1]
            // a[1][3]
            for(int i = m-1; i >= 0; i--){
                for(int j = n -1; j >= 0; j--){
                    System.out.print(data[i][j]);
                    if(j > 0){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }else if(r == -90){
            for(int i = 0; i < n; i++){
                for(int j = m - 1; j >= 0; j--){
                    System.out.print(data[j][i]);
                    if(j > 0){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
