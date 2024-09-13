package com.guanhf.trail1;

import java.util.Scanner;

public class a12 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int w = n - i - 1;
            int star = i*2 + 1;
            while(w-- != 0){
                System.out.print(" ");
            }
            while(star-- != 0){
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < n-1; i++){
            int w = i + 1;
            int star = (n - i -1) * 2 -1;
            while(w-- != 0){
                System.out.print(" ");
            }
            while(star-- != 0){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
