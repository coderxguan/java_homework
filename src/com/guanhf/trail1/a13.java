package com.guanhf.trail1;

public class a13 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                String w = i*j >= 10 ? "  ": "   ";
                System.out.print(i+ "*" + j + "=" + (i*j)+ w );
            }
            System.out.println();
        }
    }
}
