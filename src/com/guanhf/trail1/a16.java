package com.guanhf.trail1;

import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/13 17:27
 */
public class a16 {
    static  int[] a = new int[]{0, 6, 66, 666, 6666, 66666, 666666
            , 6666666, 66666666, 666666666};
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        System.out.println(sum(n));
    }

    public static int sum(int n) {
        if(n == 0){
            return 0;
        }
        return a[n] + sum(n-1);
    }
}
